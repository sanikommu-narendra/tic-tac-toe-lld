package org.example.dto;

import lombok.ToString;
import org.example.enums.CellType;

import java.util.UUID;

@ToString
public class User {
    private final String name;
    private final String id;
    private final CellType type;

    public User(String name, CellType type) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }


}
