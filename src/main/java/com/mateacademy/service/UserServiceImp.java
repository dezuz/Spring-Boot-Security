package com.mateacademy.service;

import com.mateacademy.model.UserModel;
import com.mateacademy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserModel> update(UserModel user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<UserModel> create(UserModel user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public UserModel findByFirstName(String name) {
        return userRepository.findByFirstName(name);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
