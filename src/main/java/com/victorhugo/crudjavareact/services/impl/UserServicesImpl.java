package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.mapper.UserMapper;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.repository.UserRepository;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    final UserRepository userRepository;
    //TODO - work on performance improvement and error treatment in this methods
    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) throws GenericApplicationException{
        userRepository.findByUsernameOrEmail(createUserDTO.getUsername(), createUserDTO.getEmail())
                .ifPresent(user -> {
            throw new GenericApplicationException("Já existe um cadastro com esse username e/ou esse email");
        });

        userRepository.save(UserMapper.createUserDTOtoEntity(createUserDTO));
        User userPersisted = userRepository.findByUsernameOrEmail(createUserDTO.getUsername(), createUserDTO.getEmail())
                .stream().findFirst()
                .orElseThrow(() -> new GenericApplicationException("Usuário não encontrado"));
        //TODO - retornar o id junto posteriormente
        return UserMapper.toDTO(userPersisted);
    }

    @Override
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO findUserById(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new GenericApplicationException("Usuário não encontrado"));
        return UserMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> findAllUsers() {
       List<User> userList = userRepository.findAll();
       return userList.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

}
