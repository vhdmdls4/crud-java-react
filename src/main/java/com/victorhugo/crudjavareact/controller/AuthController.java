package com.victorhugo.crudjavareact.controller;

import com.victorhugo.crudjavareact.DTO.AuthUserDTO;
import com.victorhugo.crudjavareact.DTO.RegisterUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.services.AuthService;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserServices userServices;
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthUserDTO authUserDTO){
        UsernamePasswordAuthenticationToken usernamePassAuthToken = new UsernamePasswordAuthenticationToken(authUserDTO.login(), authUserDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassAuthToken);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDTO registerUserDTO){
        try {
            UserDTO registeredUser = authService.registerUser(registerUserDTO);
            return ResponseEntity.ok(registeredUser);
        } catch (GenericApplicationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
