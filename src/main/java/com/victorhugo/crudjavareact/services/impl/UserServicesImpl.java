package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.dto.UserDto;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.mapper.UserMapper;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.repository.UserRepository;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) throws GenericApplicationException {
            User userCreated = userRepository.save(UserMapper.toEntity(userDto));
            if(userCreated != null){
                throw new GenericApplicationException("Houve um problema na criação do usuário");
            }
            return UserMapper.toDto(userCreated);

    }

}
