package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.repository.UserRepository;
import com.victorhugo.crudjavareact.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
