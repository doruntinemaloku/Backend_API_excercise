package io.backend.api.utils;

import com.mongodb.client.model.Filters;
import io.backend.api.model.User;
import org.bson.conversions.Bson;

import java.util.ArrayList;

public class AccessUtils {
    public static Bson readAccess(User user){
       return Filters.or(
                Filters.or(
                        Filters.in("readACL", user.getId().toString()),
                        Filters.in("writeACL", user.getId().toString()),

                        Filters.in("readACL", user.getRoles()),
                        Filters.in("writeACL", user.getRoles()),

                        Filters.in("readACL", "*"),
                        Filters.in("writeACL", "*")
                ),
                Filters.and(
                        Filters.eq("readACL", new ArrayList<>()),
                        Filters.eq("writeACL", new ArrayList<>())
                )
        );
    }

    public static Bson writeAccess(User user){
        return Filters.and(
                Filters.or(
                        Filters.in("writeACL", user.getId().toString()),
                        Filters.in("writeACL", user.getRoles()),
                        Filters.in("writeACL", "*")
                ),
                Filters.and(
                        Filters.eq("readACL", new ArrayList<>()),
                        Filters.eq("writeACL", new ArrayList<>())
                )

        );
    }
}
