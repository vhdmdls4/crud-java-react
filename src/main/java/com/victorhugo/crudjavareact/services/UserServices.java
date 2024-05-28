package com.victorhugo.crudjavareact.services;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    public UserDTO createUser(CreateUserDTO createUserDTO);

    public void deleteUser(Long userId);

    public UserDTO findUserById(Long userId);

    public List<UserDTO> findAllUsers();

}
