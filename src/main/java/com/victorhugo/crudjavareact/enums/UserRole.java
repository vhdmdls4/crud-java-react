package com.victorhugo.crudjavareact.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    SUPPORT("support"),
    ;
    private final String role;

}
