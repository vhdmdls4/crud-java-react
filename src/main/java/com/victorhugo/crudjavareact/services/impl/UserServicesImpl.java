package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.mapper.UserMapper;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.repository.UserRepository;
import com.victorhugo.crudjavareact.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    final UserRepository userRepository;

    //TODO - work on performance improvement and error treatment in this methods
    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) {
        validateIfUserExists(createUserDTO.getUsername(), createUserDTO.getEmail());

        User userPersisted = userRepository.save(UserMapper.createUserDTOtoEntity(createUserDTO));

        //TODO - retornar o id junto posteriormente
        return UserMapper.toDTO(userPersisted);
    }

    @Override
    public void deleteUser(Long userId) {
        this.findUserById(userId);
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

    @Override
    public Page<UserDTO> findAllUsersPageable(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(UserMapper::toDTO);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        this.findUserById(userDTO.getId());
        User user = UserMapper.toEntity(userDTO);
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO patchUser(Long id, Map<String, Object> fields) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new GenericApplicationException("Usuário não encontrado"));

        validateAndSetFields(user, fields);

        User updatedUser = userRepository.save(user);
        return UserMapper.toDTO(updatedUser);
    }

    public void validateAndSetFields(User user, Map<String, Object> fields) {
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(User.class, key);

            if (field == null) {
                throw new GenericApplicationException("Field " + key + " does not exist on User");
            }
            if (value == null && !field.getType().isPrimitive() && field.getAnnotation(NotNull.class) != null && field.getAnnotation(NotBlank.class) != null) {
                throw new GenericApplicationException("Null or empty values is not allowed for field " + key);
            }

            field.setAccessible(true);
            ReflectionUtils.setField(field, user, value);
        });
    }

    public void validateIfUserExists(String username, String email) {
        userRepository.findByUsernameOrEmail(username, email)
                .ifPresent(user -> {
                    throw new GenericApplicationException("Já existe um cadastro com esse username e/ou esse email");
                });
    }

    public Boolean checkIfUserExists(Long id, String username, String email) {
        return userRepository.findByIdOrUsernameOrEmail(id, username, email).isPresent();
    }

}
