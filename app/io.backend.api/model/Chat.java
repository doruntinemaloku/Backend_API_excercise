package io.backend.api.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Chat extends BaseModel {
    List<String> readACL = new ArrayList<>();
    List<String> writeACL = new ArrayList<>();
}
