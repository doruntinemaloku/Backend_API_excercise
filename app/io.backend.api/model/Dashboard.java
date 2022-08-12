package io.backend.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dashboard extends BaseModel {
    String name;
    String description;
    ObjectId parentId;
    List<String> readACL= new ArrayList<>();
    List<String> writeACL= new ArrayList<>();

    List<Dashboard> children= new ArrayList<>();
    List<Content> items= new ArrayList<>();
    Integer level;
}
