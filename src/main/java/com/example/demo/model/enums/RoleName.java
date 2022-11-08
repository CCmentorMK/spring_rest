package com.example.demo.model.enums;

import lombok.Getter;

@Getter
public enum RoleName {
    USER("user"),
    ADMIN("administrator");

    private String name;

    RoleName(String name) {
        this.name = name;
    }

}
