package com.mateacademy.service;

import com.mateacademy.model.Role;
import com.mateacademy.model.UserModel;
import com.mateacademy.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceImpTest {
    private UserRepository userRepository;
    private UserServiceImp userService;
    private UserModel user;

    @Before
    public void init() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImp(userRepository);
    }

    @Test
    public void updateTest() {
        user = new UserModel();
        user.setFirstName("Vasilios").setAge(19).setPassword("password").setUsername("vasilios").setRole(Role.USER);
        userService.update(user);
        verify(userRepository).save(user);
    }

    @Test
    public void createTest() {
        user = new UserModel();
        user.setFirstName("Serhij").setAge(18).setPassword("password").setUsername("dezuz").setRole(Role.USER);
        userService.create(user);
        verify(userRepository).save(user);
    }

    @Test
    public void findByFirstNameTest() {
        user = new UserModel();
        user.setFirstName("Alex");
        userService.findByFirstName(user.getFirstName());
        verify(userRepository).findByFirstName(user.getFirstName());
    }


}