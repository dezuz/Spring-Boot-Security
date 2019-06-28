package com.mateacademy.repository;

import com.mateacademy.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByFirstName(String name);
}
