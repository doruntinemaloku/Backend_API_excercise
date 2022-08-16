package io.backend.api.sevices;

import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import io.backend.api.exceptions.RequestException;
import io.backend.api.model.Content;
import io.backend.api.model.Dashboard;
import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;
import io.backend.api.utils.AccessUtils;
import org.bson.types.ObjectId;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class ContentService {
    @Inject
    HttpExecutionContext ec;

    @Inject
    IMongoDB mongoDB;

    /**
     * Get contents
     *
     * @param skip  skips over the specified number of documents
     * @param limit limits on how many items you want to get form a database list
     * @param id    dashboardId
     * @param user  authenticated user
     * @return list of contents
     */
    public CompletableFuture<List<Content>> read(int skip, int limit, String id, User user) {
        return CompletableFuture.supplyAsync(() -> {
            return mongoDB.getMongoDatabase()
                    .getCollection("contents", Content.class)
                    .find(AccessUtils.readAccess(user))
                    .filter(Filters.eq("dashboardId", new ObjectId(id)))
                    .skip(skip)
                    .limit(limit)
                    .into(new ArrayList<>());
        }, ec.current());
    }

    /**
     * Create new content
     *
     * @param content the content you want to create
     * @param id      dashboardId
     * @param user    authenticated user
     * @return content you created
     */
    public CompletableFuture<Content> create(Content content, String id, User user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                MongoCollection<Content> collection = mongoDB.getMongoDatabase().getCollection("contents", Content.class);
                collection.find(AccessUtils.writeAccess(user));

                content.setDashboardId(new ObjectId(id));
                collection.insertOne(content);

                return content;
            } catch (CompletionException e) {
                throw new CompletionException(new RequestException(Http.Status.BAD_REQUEST, ""));
            } catch (Exception e) {
                throw new CompletionException(new RequestException(Http.Status.INTERNAL_SERVER_ERROR, "parsing_exception"));
            }

        }, ec.current());
    }

    /**
     * Update a content
     *
     * @param content   the content you want to update
     * @param id        dashboardId
     * @param contentId of the content you want to update
     * @param user      authenticated user
     * @return the updated content
     */
    public CompletableFuture<Content> update(Content content, String id, String contentId, User user) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<Content> collection = mongoDB.getMongoDatabase().getCollection("contents", Content.class);
            collection.find(AccessUtils.writeAccess(user));
            //Update one content from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                content.setDashboardId(new ObjectId(id));
                collection.replaceOne(Filters.eq("_id", new ObjectId(contentId)), content);

                return content;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }

    /**
     * Delete a content
     *
     * @param content the content you want to delete
     * @param id contentId you want to delete
     * @param user  authenticated user
     * @return the deleted content
     */
    public CompletableFuture<Content> delete(Content content, String id, User user) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<Content> collection = mongoDB.getMongoDatabase().getCollection("contents", Content.class);
            collection.find(AccessUtils.writeAccess(user));

            //Delete one content from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                collection.findOneAndDelete(Filters.eq("_id", new ObjectId(id)));
                return content;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }
}
