package io.backend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Dashboard extends BaseModel{
    String name;
    String description;
    String   parentId;
    Long createdAt;
    String[] readACL;
    String[] writeACL;
}
