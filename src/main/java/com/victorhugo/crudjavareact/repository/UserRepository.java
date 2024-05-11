package com.victorhugo.crudjavareact.repository;

import com.victorhugo.crudjavareact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
