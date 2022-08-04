package io.backend.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Roles extends BaseModel{
    String name;
}
