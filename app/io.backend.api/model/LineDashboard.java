package io.backend.api.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator(key = "type", value = "Line")
@Data
public class LineDashboard extends Dashboard{
    @Override
    public Usage getType() { return Usage.LINE; }
}
