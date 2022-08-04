package io.backend.api.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import java.util.List;

@BsonDiscriminator(key = "type", value = "EMAIL")
@Data
public class EmailDashboard extends Content {
    String text;
    String subject;
    String email;
    List<String> readACL;
    List<String> writeACL;

    @Override
    public Usage getType() {
        return Usage.EMAIL;
    }
}
