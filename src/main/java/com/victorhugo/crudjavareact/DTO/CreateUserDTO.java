package com.victorhugo.crudjavareact.DTO;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO implements Serializable {
    private String name;
    private String email;
    private String username;
    private String hashPassword;
}
