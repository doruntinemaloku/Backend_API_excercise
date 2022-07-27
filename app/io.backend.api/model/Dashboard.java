package io.backend.api.model;

import lombok.Data;

import java.security.Timestamp;

@Data
public class Dashboard {
    String id;
    String name;
    String description;
    String   parentId;
    Timestamp createdAt;
    String[] readACL;
    String[] writeACL;
}
