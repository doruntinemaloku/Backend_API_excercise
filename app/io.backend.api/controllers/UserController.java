package io.backend.api.controllers;


import io.backend.api.model.User;
import io.backend.api.sevices.SerializationService;
import io.backend.api.sevices.UserService;
import io.backend.api.utils.DatabaseUtils;
import play.mvc.*;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;


public class UserController extends Controller {
    @Inject
    SerializationService serializationService;

    @Inject
    UserService service;

    /**
     * Fetch all users
     *
     * @param request HTTP request
     * @return
     */

    public CompletableFuture<Result> read(Http.Request request) {
        return service.read()
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }

    /**
     * Create User
     *
     * @param request HTTP request
     * @return
     */
 //   @Validated(type = User.class)
    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> create(Http.Request request) {
        return serializationService.parseBodyOfType(request, User.class)
                .thenCompose((data) -> service.create(data))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }

    /**
     * Update User
     *
     * @param request HTTP request
     * @param id      User Id
     * @return
     */
 //   @Validated(type = User.class)
    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> update(Http.Request request, String id) {
        return serializationService.parseBodyOfType(request, User.class)
                .thenCompose((data) -> service.update(data, id))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }

    /**
     * Delete User
     *
     * @param request HTTP request
     * @param id      User Id
     * @return
     */

    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> delete(Http.Request request, String id) {
        return serializationService.parseBodyOfType(request, User.class)
                .thenCompose((data) -> service.delete(data, id))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }

}

