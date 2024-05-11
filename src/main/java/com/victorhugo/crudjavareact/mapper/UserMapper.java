package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.dto.UserDto;
import com.victorhugo.crudjavareact.model.User;

public class UserMapper {
    public static UserDto toDto(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .hashPassword(user.getHashPassword())
                .email(user.getEmail())
                .lastSession(user.getLastSession())
                .wallet(user.getWallet())
                .transactionList(user.getTransactionList())
                .name(user.getName())
                .build();
    }
    public static User toEntity(UserDto userDto){
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
}
