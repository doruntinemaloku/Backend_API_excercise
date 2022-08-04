package io.backend.api.utils;

import io.backend.api.actions.Attributes;
import io.backend.api.model.User;
import play.libs.Json;
import play.mvc.Http;

import java.util.Optional;

public class ServiceUtils {

    public static String getTokenFromRequest(Http.Request request) {
        Optional<String> optionalToken = request.getHeaders().get("token");
        return optionalToken.orElse(null);
    }

    public static User getUserFrom(Http.Request request) {
        return request.attrs().get(Attributes.USER_TYPED_KEY);    }
}