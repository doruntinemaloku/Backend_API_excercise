package io.backend.api.sevices;

import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import io.backend.api.exceptions.RequestException;
import io.backend.api.model.Dashboard;
import io.backend.api.mongo.IMongoDB;
import org.bson.types.ObjectId;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DashboardService {
        @Inject
        HttpExecutionContext ec;

        @Inject
        IMongoDB mongoDB;

        public CompletableFuture<List<Dashboard>> read() {
            return CompletableFuture.supplyAsync(() -> {
                MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboard", Dashboard.class);

                return collection.find().into(new ArrayList<>());
            }, ec.current());
        }

        public CompletableFuture<Dashboard> create(Dashboard user) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboard", Dashboard.class);

//                    user.setCreatedAt(Timestamp.from(Instant.now()));
                    collection.insertOne(user);
                    return user;
                } catch (CompletionException e) {
                    throw new CompletionException(new RequestException(Http.Status.BAD_REQUEST, ""));
                } catch (Exception e) {
                    throw new CompletionException(new RequestException(Http.Status.INTERNAL_SERVER_ERROR, "parsing_exception"));
                }

            }, ec.current());
        }

        public CompletableFuture<Dashboard> update(Dashboard user, String id) {
            return CompletableFuture.supplyAsync(() -> {
                MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboard", Dashboard.class);

                //Update one user from database if it is already in it, if not return notFound
                if (ObjectId.isValid(id)) {
                    collection.replaceOne(Filters.eq("_id", new ObjectId(id)), user);

                    return user;
                }
                throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

            }, ec.current());
        }

        public CompletableFuture<Dashboard> delete(Dashboard user, String id) {
            return CompletableFuture.supplyAsync(() -> {
                MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboard", Dashboard.class);

                //Delete one user from database if it is already in it, if not return notFound
                if (ObjectId.isValid(id)) {
                    collection.findOneAndDelete(Filters.eq("_id", new ObjectId(id)));
                    return user;
                }
                throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

            }, ec.current());
        }
    }


