package io.backend.api.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import io.backend.api.model.Dashboard;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class BackendAPI_Controller extends Controller {
    public Result authenticate(Http.Request request){
        JsonNode jsonNode= request.body().asJson();
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


        return ok();
    }
}
