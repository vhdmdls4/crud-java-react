package com.victorhugo.crudjavareact.DTO;

import lombok.Getter;

@Getter
public record AuthDTO(String login, String password) {
}
