package io.backend.api.sevices;

import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import io.backend.api.exceptions.RequestException;

import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;
import org.bson.types.ObjectId;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class UserService {
    @Inject
    HttpExecutionContext ec;

    @Inject
    IMongoDB mongoDB;

    public CompletableFuture<List<User>> read() {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<User> collection = mongoDB.getMongoDatabase().getCollection("users", User.class);

            return collection.find().into(new ArrayList<>());
        }, ec.current());
    }

    public CompletableFuture<User> create(User user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                MongoCollection<User> collection = mongoDB.getMongoDatabase().getCollection("users", User.class);

                user.setPassword(Hash.createPassword(user.getPassword()));
                collection.insertOne(user);
                return user;
            } catch (CompletionException e) {
                throw new CompletionException(new RequestException(Http.Status.BAD_REQUEST, ""));
            } catch (Exception e) {
                throw new CompletionException(new RequestException(Http.Status.INTERNAL_SERVER_ERROR, "parsing_exception"));
            }

        }, ec.current());
    }

    public CompletableFuture<User> update(User user, String id) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<User> collection = mongoDB.getMongoDatabase().getCollection("users", User.class);

            //Update one user from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                collection.replaceOne(Filters.eq("_id", new ObjectId(id)), user);

                return user;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }

    public CompletableFuture<User> delete(User user, String id) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<User> collection = mongoDB.getMongoDatabase().getCollection("users", User.class);

            //Delete one user from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                collection.findOneAndDelete(Filters.eq("_id", new ObjectId(id)));
                return user;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }
}
