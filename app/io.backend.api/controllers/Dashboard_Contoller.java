package io.backend.api.controllers;

import io.backend.api.actions.Authenticated;
import io.backend.api.model.Dashboard;
import io.backend.api.sevices.SerializationService;
import io.backend.api.utils.DatabaseUtils;
import io.backend.api.utils.ServiceUtils;
import play.mvc.*;
import io.backend.api.sevices.DashboardService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

@Authenticated
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
        return service.read(ServiceUtils.getUserFrom(request))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(x -> {
                    x.printStackTrace();
                    return DatabaseUtils.throwableToResult(x);
                });
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

}
