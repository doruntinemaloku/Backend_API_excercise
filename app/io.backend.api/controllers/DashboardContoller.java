package io.backend.api.controllers;

import io.backend.api.actions.Authenticated;
import io.backend.api.actions.Validated;
import io.backend.api.model.Dashboard;
import io.backend.api.sevices.SerializationService;
import io.backend.api.utils.DatabaseUtils;
import io.backend.api.utils.ServiceUtils;
import play.mvc.*;
import io.backend.api.sevices.DashboardService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

@Authenticated
public class DashboardContoller extends Controller {
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
    public CompletableFuture<Result> read(int skip, int limit, Http.Request request) {
        return service.read(skip, limit, ServiceUtils.getUserFrom(request))
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
    @Validated(type = Dashboard.class)
    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> create(Http.Request request) {
        return serializationService.parseBodyOfType(request, Dashboard.class)
                .thenCompose((data) -> service.create(data, ServiceUtils.getUserFrom(request)))
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
    @Validated(type = Dashboard.class)
    @BodyParser.Of(BodyParser.Json.class)
    public CompletableFuture<Result> update(Http.Request request, String id) {
        return serializationService.parseBodyOfType(request, Dashboard.class)
                .thenCompose((data) -> service.update(data, id, ServiceUtils.getUserFrom(request)))
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
                .thenCompose((data) -> service.delete(data, id, ServiceUtils.getUserFrom(request)))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }

    public CompletableFuture<Result> hierarchy(Http.Request request) {
        return service.hierarchy(ServiceUtils.getUserFrom(request))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }
}
