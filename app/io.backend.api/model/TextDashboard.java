package io.backend.api.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import java.util.List;

@BsonDiscriminator(key = "type", value = "TEXT")
@Data
public class TextDashboard extends Content {
    String text;
    List<String> readACL;
    List<String> writeACL;

    @Override
    public Usage getType() {
        return Usage.TEXT;
    }
}
