package io.backend.api.model;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator(key = "type", value = "EMAIL")
@Data
public class EmailDashboard  extends Dashboard{

    @Override
    public Usage getType() { return Usage.EMAIL; }
}
