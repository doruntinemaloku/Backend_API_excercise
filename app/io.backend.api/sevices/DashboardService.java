package io.backend.api.sevices;

import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.GraphLookupOptions;
import io.backend.api.exceptions.RequestException;
import io.backend.api.model.BaseModel;
import io.backend.api.model.Content;
import io.backend.api.model.Dashboard;
import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;
import io.backend.api.utils.AccessUtils;
import org.bson.BsonNull;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

public class DashboardService {
    @Inject
    HttpExecutionContext ec;

    @Inject
    IMongoDB mongoDB;

    /**
     * Get all dashboards
     *
     * @param skip  skips over the specified number of documents
     * @param limit limits on how many items you want to get form a database list
     * @param user  authenticate user
     * @return list of dashboards
     */
    public CompletableFuture<List<Dashboard>> read(int skip, int limit, User user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                List<Dashboard> dashboards = mongoDB.getMongoDatabase()
                        .getCollection("dashboards", Dashboard.class)
                        .find(AccessUtils.readAccess(user))
                        .skip(skip)
                        .limit(limit)
                        .into(new ArrayList<>());

                List<ObjectId> id = dashboards.stream().map(BaseModel::getId).collect(Collectors.toList());

                List<Content> content = mongoDB.getMongoDatabase().getCollection("contents", Content.class)
                        .find()
                        .filter(Filters.in("dashboardId", id))
                        .into(new ArrayList<>());

                dashboards.forEach(x -> x.setItems(content.stream()
                        .filter(y -> y.getDashboardId().equals(x.getId()))
                        .collect(Collectors.toList())));
                return dashboards;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }, ec.current());
    }

    /**
     * create new dashboard
     *
     * @param dashboard you want to create
     * @param user      authenticated user
     * @return the new created dashboard
     */
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

    /**
     * Update dashboard
     *
     * @param dashboard you want to update
     * @param id        dashboardId you want to update
     * @param user      authanticated user
     * @return updated dashboard
     */
    public CompletableFuture<Dashboard> update(Dashboard dashboard, String id, User user) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboards", Dashboard.class);
            collection.find(AccessUtils.writeAccess(user));
            //Update one user from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                collection.replaceOne(eq("_id", new ObjectId(id)), dashboard);

                return dashboard;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }

    /**
     * Delete a dashboard
     *
     * @param dashboard the dashboard you want to delete
     * @param id dashboardId you want to delete
     * @param user authenticated user
     * @return the deleted dashboard
     */
    public CompletableFuture<Dashboard> delete(Dashboard dashboard, String id, User user) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboards", Dashboard.class);
            collection.find(AccessUtils.writeAccess(user));

            //Delete one user from database if it is already in it, if not return notFound
            if (ObjectId.isValid(id)) {
                collection.findOneAndDelete(eq("_id", new ObjectId(id)));
                return dashboard;
            }
            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, ""));

        }, ec.current());
    }

    /**
     * Get the Dashboards and their hierarchy
     * @return return list of Dashboards
     */
    public CompletableFuture<List<Dashboard>> hierarchy() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                MongoCollection<Dashboard> collection = mongoDB.getMongoDatabase().getCollection("dashboards", Dashboard.class);

                List<Bson> pipeline = new ArrayList<>();
                pipeline.add(Aggregates.match(eq("parentId", new BsonNull())));
                pipeline.add(Aggregates
                        .graphLookup("dashboards"
                                , "$_id"
                                , "_id"
                                , "parentId"
                                , "children"
                                , new GraphLookupOptions().depthField("level")));

                List<Dashboard> dashboards = collection
                        .aggregate(pipeline, Dashboard.class)
                        .into(new ArrayList<>());

                List<Dashboard> dashboardsFlat = dashboards.stream()
                        .map(Dashboard::getChildren)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
                dashboardsFlat.addAll(dashboards);

                List<ObjectId> id = dashboardsFlat.stream().map(BaseModel::getId).collect(Collectors.toList());

                List<Content> content = mongoDB.getMongoDatabase().getCollection("contents", Content.class)
                        .find()
                        .filter(Filters.in("dashboardId", id))
                        .into(new ArrayList<>());

                dashboardsFlat.forEach(x -> x.setItems(content.stream()
                        .filter(y -> y.getDashboardId().equals(x.getId()))
                        .collect(Collectors.toList())));


                dashboards.forEach(d -> {
                    List<Dashboard> children = d.getChildren();
                    List<Dashboard> prinderit = children.stream()
                            .reduce(new ArrayList<>(), (lista, x) -> {
                                x.setChildren(children.stream()
                                        .filter(u -> x.getId().equals(u.getParentId()))
                                        .collect(Collectors.toList()));
                                if (x.getLevel() == 0) {
                                    lista.add(x);
                                }
                                return lista;
                            }, (a, b) -> a);

                    d.setChildren(prinderit);
                });
                return dashboards;
            } catch (Exception e) {
                throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, "Something went wrong. " + e.getMessage()));
            }
        }, ec.current());
    }
}


