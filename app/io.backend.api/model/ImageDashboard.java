package io.backend.api.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator(key = "type", value = "TEXT")
@Data
public class ImageDashboard extends Dashboard{
    @Override
    public Usage getType() { return Usage.IMAGE; }
}
