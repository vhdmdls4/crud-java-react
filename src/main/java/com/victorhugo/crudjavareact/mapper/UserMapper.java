package com.victorhugo.crudjavareact.mapper;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.model.User;


public class UserMapper {
    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .hashPassword(user.getHashPassword())
                .lastSession(user.getLastSession())
                .wallet(
                        WalletMapper.toDTO(user.getWallet()))
                .communityWalletList(
                        user.getCommunityWalletList().stream().map(CommunityWalletMapper::toDTO).toList())
                .build();
    }
    public static User toEntity(UserDTO userDto){
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .hashPassword(userDto.getHashPassword())
                .lastSession(userDto.getLastSession())
                .wallet(
                        WalletMapper.toEntity(userDto.getWallet()))
                .communityWalletList(
                        userDto.getCommunityWalletList().stream().map(CommunityWalletMapper::toEntity).toList())
                .build();
    }

    public static CreateUserDTO entityToCreateUserDTO(User user){
        return CreateUserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
    public static User createUserDTOtoEntity(CreateUserDTO createUserDTO){
        return User.builder()
                .name(createUserDTO.getName())
                .email(createUserDTO.getEmail())
                .username(createUserDTO.getUsername())
                .hashPassword(createUserDTO.getPassword())
                .build();
    }
}
