package io.backend.api.actions;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.backend.api.model.User;
import io.backend.api.model.validator.HibernateValidator;
import io.backend.api.mongo.IMongoDB;
import io.backend.api.utils.AuthenticateUtils;
import io.backend.api.utils.ServiceUtils;
import org.bson.types.ObjectId;
import play.api.mvc.Request;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.mongodb.client.model.Filters.eq;

public class AuthenticatedAction extends Action<Authenticated> {

    @Inject
    IMongoDB mongoDB;

    @Inject
    Config config;

    @Override
    @BodyParser.Of(BodyParser.Json.class)
    public CompletionStage<Result> call(Http.Request request) {
        try {
            String token = AuthenticateUtils.getTokenFromRequest(request);
            User user = AuthenticateUtils.verifyToken(token, config)
                    .thenCompose(AuthenticateUtils::getIdFromToken)
                    .thenCompose(id -> AuthenticateUtils.getUser(id, mongoDB))
                    .join();

            request = request.addAttr(Attributes.USER_TYPED_KEY, user);
            return delegate.call(request);
        } catch (JWTVerificationException e) {
            return CompletableFuture.completedFuture(forbidden("TOKEN NOT VERIFIED"));
        } catch (Exception e) {
            return CompletableFuture.completedFuture(badRequest());
        }
    }
}
