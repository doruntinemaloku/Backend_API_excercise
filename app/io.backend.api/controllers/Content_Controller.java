package io.backend.api.controllers;

import io.backend.api.actions.Authenticated;
import io.backend.api.model.Content;
import io.backend.api.sevices.ContentService;
import io.backend.api.sevices.SerializationService;
import io.backend.api.utils.DatabaseUtils;

import io.backend.api.utils.ServiceUtils;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;

import java.util.concurrent.CompletableFuture;

@Authenticated
public class Content_Controller {
    @Inject
    SerializationService serializationService;

    @Inject
    ContentService service;

    /**
     * Fetch all users
     *
     * @param request HTTP request
     * @return
     */
    public CompletableFuture<Result> read(Http.Request request, String id) {
        return service.read(id, ServiceUtils.getUserFrom(request))
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
    public CompletableFuture<Result> create(Http.Request request, String id) {
        return serializationService.parseBodyOfType(request, Content.class)
                .thenCompose((data) -> service.create(data, id, ServiceUtils.getUserFrom(request)))
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
    public CompletableFuture<Result> update(Http.Request request, String id, String contentId) {
        return serializationService.parseBodyOfType(request, Content.class)
                .thenCompose((data) -> service.update(data, id, contentId, ServiceUtils.getUserFrom(request)))
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
    public CompletableFuture<Result> delete(Http.Request request, String id, String contentId) {
        return serializationService.parseBodyOfType(request, Content.class)
                .thenCompose((data) -> service.delete(data, contentId, ServiceUtils.getUserFrom(request)))
                .thenCompose((data) -> serializationService.toJsonNode(data))
                .thenApply(Results::ok)
                .exceptionally(DatabaseUtils::throwableToResult);
    }


}
