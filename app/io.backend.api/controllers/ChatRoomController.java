package io.backend.api.controllers;

import akka.actor.ActorSystem;
import akka.stream.Materializer;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.typesafe.config.Config;
import io.backend.api.actions.Authenticated;
import io.backend.api.actors.ChatActor;
import io.backend.api.exceptions.RequestException;
import io.backend.api.model.Chat;
import io.backend.api.model.Dashboard;
import io.backend.api.model.User;
import io.backend.api.mongo.IMongoDB;
import io.backend.api.utils.AccessUtils;
import io.backend.api.utils.AuthenticateUtils;
import org.bson.types.ObjectId;
import play.libs.F;
import play.libs.Json;
import play.libs.streams.ActorFlow;
import play.mvc.Http;
import play.mvc.WebSocket;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static play.mvc.Results.badRequest;


public class ChatRoomController {
    @Inject
    Config config;
    @Inject
    IMongoDB mongoDB;
    @Inject
    private ActorSystem actorSystem;
    @Inject
    private Materializer materializer;

    public WebSocket chat(String roomId, String token) {

        return WebSocket.Text.acceptOrResult(request ->
                {
                    try {
                        User user = AuthenticateUtils.verifyToken(token, config)
                                .thenCompose(AuthenticateUtils::getIdFromToken)
                                .thenCompose(id -> AuthenticateUtils.getUser(id, mongoDB))
                                .join();
                        if (user == null) {
                            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, Json.toJson("User not found!")));
                        }

                        MongoCollection<Chat> collection = mongoDB
                                .getMongoDatabase()
                                .getCollection("chat", Chat.class);

                        Chat chat = collection.find(Filters.eq("_id", new ObjectId(roomId))).first();
                        if (chat == null) {
                            throw new CompletionException(new RequestException(Http.Status.NOT_FOUND, Json.toJson("Chat not found!")));
                        }
                        String userId = user.getId().toString();
                        List<String> roles = user.getRoles();
                        boolean read = false;
                        boolean write = false;
                        for (String id : roles) {
                            if (chat.getReadACL().contains(id) || chat.getReadACL().contains(userId)) {
                                read = true;
                            }
                            if (chat.getWriteACL().contains(id) || chat.getWriteACL().contains(userId)) {
                                read = true;
                                write = true;
                            }

                        }

                        if (!read) {
                            throw new CompletionException(new RequestException(Http.Status.FORBIDDEN, Json.toJson("You don't have permission")));
                        }

                        boolean finalWrite = write;
                        return CompletableFuture.completedFuture(F.Either.Right(ActorFlow.actorRef((out) -> ChatActor.props(out, roomId, finalWrite), actorSystem, materializer)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return CompletableFuture.completedFuture(F.Either.Left(badRequest()));
                    }
                }
        );
    }
}
