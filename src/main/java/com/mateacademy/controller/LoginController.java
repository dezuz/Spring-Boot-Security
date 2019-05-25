package com.mateacademy.controller;

import com.mateacademy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String login(Principal principal) {
        return "login.html";
    }

}
