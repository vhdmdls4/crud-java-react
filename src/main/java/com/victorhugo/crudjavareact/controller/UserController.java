package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final UserServices userServices;
    //TODO - create a response wrapper to send message and content to front instead of ResponseEntity<GenericDTO>
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO){
        try {
            UserDTO userCreated = userServices.createUser(createUserDTO);
            return ResponseEntity.ok().body(userCreated);
        } catch (GenericApplicationException exception){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        try {
            List<UserDTO> userDTOList = userServices.findAllUsers();
            return ResponseEntity.ok().body(userDTOList);
        } catch (GenericApplicationException exception){
            return ResponseEntity.internalServerError().build();
        }
    }
}
