package io.backend.api.controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import io.backend.api.model.Dashboard;
import io.backend.api.sevices.SerializationService;
import io.backend.api.utils.DatabaseUtils;
import play.libs.Json;
import play.mvc.*;
import io.backend.api.sevices.DashboardService;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Dashboard_Contoller extends Controller {
    @Inject
     SerializationService serializationService;

    @Inject
    DashboardService service;

    /**
     * Fetch all users
     *
     * @param request HTTP request
     * @return
     */
    @BodyParser.Of(BodyParser.Json.class)
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

    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> create(Http.Request request) {
        return serializationService.parseBodyOfType(request, Dashboard.class)
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

    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> update(Http.Request request, String id) {
        return serializationService.parseBodyOfType(request, Dashboard.class)
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
        return serializationService.parseBodyOfType(request, Dashboard.class)
                .thenCompose((data) -> service.delete(data, id))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }

    public List<Dashboard> from(ArrayNode users) {
        return StreamSupport
                .stream(users.spliterator(), true)
                .map(next -> Json.fromJson(next, Dashboard.class))
                .collect(Collectors.toList());
    }
}
