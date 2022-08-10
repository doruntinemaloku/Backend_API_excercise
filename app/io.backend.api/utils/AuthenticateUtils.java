package io.backend.api.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.Config;
import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;
import org.bson.types.ObjectId;
import play.libs.Json;
import play.mvc.Http;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static com.mongodb.client.model.Filters.eq;

public class AuthenticateUtils {

    public static String getTokenFromRequest(Http.Request request) {
        Optional<String> optionalToken = request.getHeaders().get("token");
        return optionalToken.orElse(null);
    }

    public static CompletableFuture<String> verifyToken(String token, Config config) throws UnsupportedEncodingException {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String secret = config.getString("play.http.secret.key");
                Algorithm algorithm = Algorithm.HMAC256(secret);

                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);
                return token;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public static CompletableFuture<String> getIdFromToken(String token) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String[] parts = token.split("\\.");

                String payload = new String(Base64.getUrlDecoder().decode(parts[1]));
                JsonNode tree = null;
                tree = Json.mapper().readTree(payload);

                return tree.get("id").asText();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public static CompletableFuture<User> getUser(String id, IMongoDB mongoDB) {
        return CompletableFuture.supplyAsync(() -> {
            User user = mongoDB
                    .getMongoDatabase()
                    .getCollection("users", User.class)
                    .find(eq("_id", new ObjectId(id)))
                    .first();
            return user;
        });
    }
}
