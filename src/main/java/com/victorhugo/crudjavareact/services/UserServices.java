package com.victorhugo.crudjavareact.services;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserServices {
    UserDTO createUser(CreateUserDTO createUserDTO);

    void deleteUser(Long userId);

    UserDTO findUserById(Long userId);

    List<UserDTO> findAllUsers();

    Page<UserDTO> findAllUsersPageable(Pageable pageable);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO patchUser(Long id, Map<String, Object> fields);

    Boolean checkIfUserExists(Long id, String username, String email);
}
