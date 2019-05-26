package com.mateacademy.controller;

import com.mateacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(Principal principal) {
        return "login";
    }

}
