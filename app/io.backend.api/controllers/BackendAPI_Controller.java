package io.backend.api.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import io.backend.api.model.Dashboard;
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

import static com.mongodb.client.model.Filters.eq;

public class BackendAPI_Controller extends Controller {
    public Result authenticate(Http.Request request){
        JsonNode jsonNode= request.body().asJson();

        MongoClient mongo = MongoClients.create();
        MongoDatabase database = mongo.getDatabase("BackendApi");
        MongoCollection<Document> collection = database.getCollection("User");

        collection.find(eq("username",jsonNode.get("username")));
        String encode = Jwts.builder()
                .claim("username", jsonNode.get("username"))
                .claim("password", jsonNode.get("password"))
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();
        System.out.println(encode);
        return ok(Json.toJson(encode));
    }

    public Result create(Http.Request request){
        JsonNode jsonNode= request.body().asJson();
        Dashboard dashboard= Json.fromJson(jsonNode, Dashboard.class);

        MongoClient mongo = MongoClients.create();
        MongoDatabase database = mongo.getDatabase("BackendApi");
        MongoCollection<Document> collection = database.getCollection("Dashboard");


        return ok();
                
    }
}
