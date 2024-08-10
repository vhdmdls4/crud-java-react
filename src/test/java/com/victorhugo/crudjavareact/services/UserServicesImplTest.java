package com.victorhugo.crudjavareact.services;

import com.victorhugo.crudjavareact.DTO.CreateUserDTO;
import com.victorhugo.crudjavareact.exception.GenericApplicationException;
import com.victorhugo.crudjavareact.model.User;
import com.victorhugo.crudjavareact.repository.UserRepository;
import com.victorhugo.crudjavareact.services.impl.UserServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//class UserServicesImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserServicesImpl userServices;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    @DisplayName("Should create a user successfully")
//    void createUser() {
//
//
//    }
//
//    @Test
//    @DisplayName("Should fail when creating a user with existing username or email")
//    void createUserCaseUserAlreadyExistWithUsernameOrEmail() {
//        // Arrange
//        String existingUsername = "existingUsername";
//        String existingEmail = "existingEmail@example.com";
//
//        User existingUser = new User();
//        existingUser.setUsername(existingUsername);
//        existingUser.setEmail(existingEmail);
//
//        when(userRepository.findByUsernameOrEmail(existingUsername, existingEmail))
//                .thenReturn(Optional.of(existingUser));
//
//        CreateUserDTO newUser = new CreateUserDTO();
//        newUser.setUsername(existingUsername);
//        newUser.setEmail(existingEmail);
//
//        // Act and Assert
//        assertThrows(GenericApplicationException.class, () -> userServices.createUser(newUser));
//    }
//
//    @Test
//    @DisplayName("Should create a user successfully")
//    void createUserCaseUserDont() {
//
//
//    }
//
//    @Test
//    void deleteUser() {
//    }
//
//    @Test
//    void findUserById() {
//    }
//
//    @Test
//    void findAllUsers() {
//    }
//
//    @Test
//    void findAllUsersPageable() {
//    }
//
//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void patchUser() {
//    }
//
//    @Test
//    void validateAndSetFields() {
//    }
//
//    @Test
//    void validateIfUserExists() {
//    }
//
//    @Test
//    void checkIfUserExists() {
//    }
//    }