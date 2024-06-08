package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final UserServices userServices;
    //TODO - create a response wrapper to send message and content to front instead of ResponseEntity<GenericDTO>
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
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

    @GetMapping("/page")
    public ResponseEntity<Page<UserDTO>> findAllUsersPageable(@PathVariable Integer page, @RequestParam(defaultValue = "10") Integer size){
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<UserDTO> userDTOPage = userServices.findAllUsersPageable(pageable);
            return ResponseEntity.ok().body(userDTOPage);
        } catch (GenericApplicationException exception){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        try {
            userServices.deleteUser(userId);
            return ResponseEntity.ok("Usuário deletado com sucesso");
        } catch (GenericApplicationException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long userId){
        try {
            UserDTO userDTO = userServices.findUserById(userId);
            return ResponseEntity.ok(userDTO);
        } catch (GenericApplicationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO){
        try {
            UserDTO updatedUserDTO = userServices.updateUser(userDTO);
            return ResponseEntity.ok(updatedUserDTO);
        } catch (GenericApplicationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
