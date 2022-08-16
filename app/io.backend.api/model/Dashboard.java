package io.backend.api.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dashboard extends BaseModel {

    @NotEmpty
    String name;
    String description;

    @JsonSerialize(using = io.training.api.mongo.serializers.ObjectIdStringSerializer.class)
    @JsonDeserialize(using = io.training.api.mongo.serializers.ObjectIdDeSerializer.class)
    ObjectId parentId;

    List<String> readACL= new ArrayList<>();
    List<String> writeACL= new ArrayList<>();

    @BsonIgnore
    List<Dashboard> children= new ArrayList<>();

    @BsonIgnore
    List<Content> items= new ArrayList<>();

    @BsonIgnore
    Integer level;
}
