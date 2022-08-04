package io.backend.api.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import io.backend.api.model.validator.HibernateValidator;
import play.mvc.Action;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.libs.Json;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static play.mvc.BodyParser.*;
import static play.mvc.Results.badRequest;

public class ValidatedAction extends Action<Validated> {

    @Override
    @Of(BodyParser.Json.class)
    public CompletionStage<Result> call(Http.Request request) {
        try {
            JsonNode body = request.body().asJson();
            Object object = Json.fromJson(body, configuration.type());

            String errors = HibernateValidator.validate(object);
            if (!Strings.isNullOrEmpty(errors)) {
                return CompletableFuture.completedFuture(badRequest(Json.toJson(errors)));
            }

            return delegate.call(request);
        } catch (Exception ex) {
            ex.printStackTrace();
            ObjectNode response = Json.newObject();
            response.put("message", "Invalid object supplied, cannot cast to type Dashboard.");
            return CompletableFuture.completedFuture(badRequest(response));
        }
    }
}
