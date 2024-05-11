package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.dto.UserDto;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final UserServices userServices;
    @PostMapping
    public ResponseEntity<UserDto> createUser(UserDto userDto){
        try {
            UserDto userCreated = userServices.createUser(userDto);
            return ResponseEntity.ok().body(userDto);
        } catch (GenericApplicationException exception){
            return ResponseEntity.badRequest().build();
        }
    }
}
