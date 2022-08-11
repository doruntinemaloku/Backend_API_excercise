package io.backend.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dashboard extends BaseModel {
    String name;
    String description;
    ObjectId parentId;
    Long createdAt;
    List<String> readACL;
    List<String> writeACL;

    List<Dashboard> children;
    List<Content> items;

    @BsonProperty
    Integer level;
}
