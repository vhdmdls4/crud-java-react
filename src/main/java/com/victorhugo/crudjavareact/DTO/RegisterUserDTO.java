package com.victorhugo.crudjavareact.DTO;

import com.victorhugo.crudjavareact.enums.UserRole;

public record RegisterUserDTO(String name, String email, String username, String password, UserRole role) {
}
