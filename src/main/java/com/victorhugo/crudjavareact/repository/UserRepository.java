package com.victorhugo.crudjavareact.repository;

import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);
    UserDetails findByUsername(String username);

    Optional<Object> findByIdOrUsernameOrEmail(Long id, @NotBlank @NotEmpty String username, @NotBlank @NotEmpty String email);
    //TODO - filter the User Entity by deleted column
}
