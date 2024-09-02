package com.victorhugo.crudjavareact.services;

import com.victorhugo.crudjavareact.DTO.RegisterUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService extends UserDetailsService {
    UserDTO registerUser(RegisterUserDTO registerUserDTO);
}
