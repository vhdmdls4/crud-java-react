package com.victorhugo.crudjavareact.repository;

import com.victorhugo.crudjavareact.DTO.UserDTO;
import com.victorhugo.crudjavareact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);
    //TODO - filter the User Entity by deleted column
}
