package io.backend.api.actions;


import io.backend.api.model.User;
import play.libs.typedmap.TypedKey;

public class Attributes {
    public static final TypedKey<User> USER_TYPED_KEY = TypedKey.<User>create("user");
}