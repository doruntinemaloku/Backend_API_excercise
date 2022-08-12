package io.backend.api.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator(key = "type", value = "IMAGE")
@Data
public class ImageDashboard extends Content{
    String url;
    @Override
    public Usage getType() { return Usage.IMAGE; }
}
