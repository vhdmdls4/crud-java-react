package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.model.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .username(user.getUsername())
                .hashPassword(user.getHashPassword())
                .email(user.getEmail())
                .lastSession(user.getLastSession())
                .wallet(user.getWallet())
                .transactionList(user.getTransactionList())
                .name(user.getName())
                .id(user.getId())
                .build();
    }
    public static User toEntity(UserDTO userDto){
        return User.builder()
                .username(userDto.getUsername())
                .hashPassword(userDto.getHashPassword())
                .email(userDto.getEmail())
                .lastSession(userDto.getLastSession())
                .wallet(userDto.getWallet())
                .transactionList(userDto.getTransactionList())
                .name(userDto.getName())
                .build();
    }

    public static CreateUserDTO entityToCreateUserDTO(User user){
        return CreateUserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .hashPassword(user.getHashPassword())
                .name(user.getName())
                .build();
    }
    public static User createUserDTOtoEntity(CreateUserDTO createUserDTO){
        return User.builder()
                .username(createUserDTO.getUsername())
                .email(createUserDTO.getEmail())
                .hashPassword(createUserDTO.getHashPassword())
                .name(createUserDTO.getName())
                .build();
    }
}
