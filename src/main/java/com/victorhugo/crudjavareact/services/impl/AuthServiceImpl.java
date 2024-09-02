package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.RegisterUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.mapper.UserMapper;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.repository.UserRepository;
import com.victorhugo.crudjavareact.services.AuthService;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserServices userServices;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDTO registerUser(RegisterUserDTO registerUserDTO){
        userServices.validateIfUserExists(registerUserDTO.username(), registerUserDTO.email());
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerUserDTO.password());
        User newUser = new User(registerUserDTO.name(), registerUserDTO.email(), registerUserDTO.username(), encryptedPassword, registerUserDTO.role());
        CreateUserDTO convertedNewUser = UserMapper.entityToCreateUserDTO(newUser);
        return userServices.createUser(convertedNewUser);
    }
}
