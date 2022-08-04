package io.backend.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.backend.api.model.examples.FreeUser;
import io.backend.api.model.examples.PremiumUser;
import io.backend.api.model.examples.SubscriberUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value= EmailDashboard.class, name = "EMAIL"),
        @JsonSubTypes.Type(value= TextDashboard.class, name = "TEXT"),
        @JsonSubTypes.Type(value= LineDashboard.class, name = "LINE"),
        @JsonSubTypes.Type(value= ImageDashboard.class, name = "IMAGE")

})
@BsonDiscriminator(key = "type", value = "NONE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Content extends BaseModel{

    @BsonIgnore
    Usage type= Usage.NONE ;
    ObjectId dashboardID;
}
