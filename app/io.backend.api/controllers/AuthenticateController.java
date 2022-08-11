package io.backend.api.controllers;

import io.backend.api.model.User;

import io.backend.api.sevices.AuthenticateService;

import io.backend.api.sevices.SerializationService;
import io.backend.api.utils.DatabaseUtils;

import play.mvc.*;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;


public class AuthenticateController extends Controller {
    @Inject
    SerializationService serializationService;
    @Inject
    AuthenticateService service;

    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> authenticate(Http.Request request) {
        return serializationService.parseBodyOfType(request, User.class)
                .thenCompose((data) -> service.authenticate(data))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }

}
