package io.backend.api.sevices;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.typesafe.config.ConfigFactory;
import io.backend.api.exceptions.RequestException;

import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;

import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class AuthenticateService {

    @Inject
    HttpExecutionContext ec;

    @Inject
    IMongoDB mongoDB;

    public CompletableFuture<String> authenticate(User user1) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                MongoCollection<User> collection = mongoDB.getMongoDatabase().getCollection("users", User.class);

                User user = collection.find(
                                Filters.eq("username", user1.getUsername())
                        )
                        .first();
                if (user == null) {
                    throw new CompletionException(new RequestException(Http.Status.BAD_REQUEST, ""));
                }

                if (!Hash.checkPassword(user1.getPassword(), user.getPassword())) {
                    throw new CompletionException(new RequestException(Http.Status.UNAUTHORIZED, Json.toJson("You are not authorized! Password Related")));
                }

                Algorithm algorithm = Algorithm.HMAC256(ConfigFactory.load().getString("play.http.secret.key"));

                return JWT.create()
                        .withClaim("id", user.getId().toString())
                        .sign(algorithm);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, ec.current());
    }
}
