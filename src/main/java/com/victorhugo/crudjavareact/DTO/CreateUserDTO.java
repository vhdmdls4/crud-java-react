package com.victorhugo.crudjavareact.DTO;

import com.victorhugo.crudjavareact.enums.UserRole;
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
    private String password;
    private UserRole userRole;
}
