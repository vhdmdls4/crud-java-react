package com.victorhugo.crudjavareact.services;

import com.victorhugo.crudjavareact.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    public UserDto createUser(UserDto userDto);

}
