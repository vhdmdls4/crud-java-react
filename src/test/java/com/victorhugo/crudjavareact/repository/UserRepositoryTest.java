package com.victorhugo.crudjavareact.repository;

import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.mapper.UserMapper;
import com.victorhugo.crudjavareact.model.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


//eh possivel fazer testes usando outro banco mas com o mesmo sgbd, para isso eh necessario criar um banco de teste
//e configurar o application.properties para usar o banco de teste, entretanto, é muito custoso e desnecessario
//posso usar um banco em memoria, que é mais rapido e mais facil de configurar
@ActiveProfiles("test")
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    EntityManager entityManager;
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Should return a user by username or email")
    void findByUsernameOrEmailCaseSuccess() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("victor");
        userDTO.setEmail("iooi@gmail.com");
        userDTO.setName("victor");
        userDTO.setHashPassword("123");
        userDTO.setWallet(null);
        userDTO.setCommunityWalletList(null);
        this.createUser(userDTO);

        Optional<User> foundUser = userRepository.findByUsernameOrEmail(userDTO.getUsername(), userDTO.getEmail());
        assertThat((foundUser).isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should return a user by username or email")
    void findByUsernameOrEmailCaseEmpty() {
        String username = "wictor";
        String email = "";
        Optional<User> foundUser = userRepository.findByUsernameOrEmail(username, email);
        assertThat((foundUser).isEmpty()).isTrue();
    }

    @Test
    void findByIdOrUsernameOrEmail() {
    }

    private User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setDeleted(false);
        user.setName(userDTO.getName());
        user.setCommunityWalletList(null);
        user.setHashPassword(userDTO.getHashPassword());
        user.setLastSession(null);
        user.setWallet(null);

        this.entityManager.persist(user);
        return user;
    }
}