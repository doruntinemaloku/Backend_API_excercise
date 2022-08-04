package io.backend.api.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.typesafe.config.ConfigFactory;
import io.backend.api.exceptions.RequestException;
import io.backend.api.model.Dashboard;
import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;
import io.backend.api.sevices.Hash;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bson.Document;
import org.bson.types.ObjectId;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import com.mongodb.client.MongoCollection;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.concurrent.CompletionException;

import static com.mongodb.client.model.Filters.eq;

public class BackendAPI_Controller extends Controller {
    @Inject
    IMongoDB mongoDB;

    public Result authenticate(Http.Request request) {
        try {
            JsonNode jsonNode = request.body().asJson();
            User user1=Json.fromJson(jsonNode, User.class);
            MongoCollection<User> collection = mongoDB.getMongoDatabase().getCollection("users", User.class);

            User user = collection.find(
                            Filters.eq("username", user1.getUsername())
                          )
                    .first();
            if (user == null) {
                return badRequest();
            }

            if (!Hash.checkPassword(user1.getPassword(), user.getPassword())) {
                throw new CompletionException(new RequestException(Http.Status.UNAUTHORIZED, Json.toJson("You are not authorized! Password Related")));
            }

            Algorithm algorithm = Algorithm.HMAC256(ConfigFactory.load().getString("play.http.secret.key"));
            String token = JWT.create()
                    .withClaim("id", user.getId().toString())
                    .sign(algorithm);

            return ok(Json.toJson(token));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Result verify(Http.Request request) {
        try {
            String token = request.header("token").get();

            Algorithm algorithm = Algorithm.HMAC256(ConfigFactory.load().getString("play.http.secret.key"));
            JWTVerifier verifier = JWT.require(algorithm)
                                      .build();
            DecodedJWT jwt = verifier.verify(token);

            String[] parts = token.split("\\.");

            String payload = new String(Base64.getUrlDecoder().decode(parts[1]));
//            System.out.println(payload);
            JsonNode tree = Json.mapper().readTree(payload);

            User user1 = mongoDB
                    .getMongoDatabase()
                    .getCollection("user", User.class)
                    .find(
                            eq("_id", new ObjectId(tree.get("id").asText()))
                    )
                    .first();
            return ok(Json.toJson(user1));
        } catch (JWTVerificationException e) {
            return forbidden("TOKEN NOT VERIFIED");
        } catch (Exception e) {
            return internalServerError();
        }
    }
}
