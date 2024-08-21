package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.AuthDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO){
        UsernamePasswordAuthenticationToken usernamePassAuthToken = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password());
        return ResponseEntity.ok().build();
    }
}
