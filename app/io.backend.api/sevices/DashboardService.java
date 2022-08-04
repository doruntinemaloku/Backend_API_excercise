package io.backend.api.sevices;

import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import io.backend.api.exceptions.RequestException;
import io.backend.api.model.BaseModel;
import io.backend.api.model.Content;
import io.backend.api.model.Dashboard;
import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;
import io.backend.api.utils.AccessUtils;
import org.bson.types.ObjectId;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

public class DashboardService {
    @Inject
    HttpExecutionContext ec;

    @Inject
    IMongoDB mongoDB;

    public CompletableFuture<List<Dashboard>> read(User user) {
        return CompletableFuture.supplyAsync(() -> {
            int skip=0, limit=100;

            List<Dashboard> dashboards = mongoDB.getMongoDatabase()
                    .getCollection("dashboards", Dashboard.class)
                    .find(AccessUtils.readAccess(user))
                    .skip(skip)
                    .limit(limit)
                    .into(new ArrayList<>());

            List<ObjectId> id = dashboards.stream().map(BaseModel::getId).collect(Collectors.toList());

            List<Content> content = mongoDB.getMongoDatabase().getCollection("contents", Content.class)
                    .find()
                    .filter(Filters.in("dashboardID", id))
                    .into(new ArrayList<>());

            dashboards.forEach(x -> x.setItems(content.stream()
                    .filter(y -> y.getDashboardID().equals(x.getId()))
                    .collect(Collectors.toList())));
            return dashboards;
        }, ec.current());
    }

    public CompletableFuture<Dashboard> create(Dashboard dashboard, User user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboards", Dashboard.class);
                collection.find(AccessUtils.writeAccess(user));

                collection.insertOne(dashboard);
                return dashboard;
            } catch (CompletionException e) {
                throw new CompletionException(new RequestException(Http.Status.BAD_REQUEST, ""));
            } catch (Exception e) {
                throw new CompletionException(new RequestException(Http.Status.INTERNAL_SERVER_ERROR, "parsing_exception"));
            }

        }, ec.current());
    }

    public CompletableFuture<Dashboard> update(Dashboard dashboard, String id, User user) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboards", Dashboard.class);
            collection.find(AccessUtils.writeAccess(user));
            //Update one user from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                collection.replaceOne(Filters.eq("_id", new ObjectId(id)), dashboard);

                return dashboard;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }

    public CompletableFuture<Dashboard> delete(Dashboard dashboard, String id, User user) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboards", Dashboard.class);
            collection.find(AccessUtils.writeAccess(user));

            //Delete one user from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                collection.findOneAndDelete(Filters.eq("_id", new ObjectId(id)));
                return dashboard;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }

}


