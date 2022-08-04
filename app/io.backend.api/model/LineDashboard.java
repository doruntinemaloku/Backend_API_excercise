package io.backend.api.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import java.util.List;

@BsonDiscriminator(key = "type", value = "Line")
@Data
public class LineDashboard extends Content{
    List<Data> data;
    @Override
    public Usage getType() { return Usage.LINE; }
}
