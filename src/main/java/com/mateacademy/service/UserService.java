package com.mateacademy.service;

import com.mateacademy.model.UserModel;

import java.util.Optional;

public interface UserService {

    Optional<UserModel> create(UserModel user);

    Optional<UserModel> getById(Long id);

    Optional<UserModel> update(UserModel user);

    UserModel findByFirstName(String name);

    void delete(Long id);
}
