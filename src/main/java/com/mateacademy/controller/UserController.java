package com.mateacademy.controller;

import com.mateacademy.model.UserModel;
import com.mateacademy.service.UserService;
import com.mateacademy.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;
    private SecurityService utils;

    @GetMapping(value = "/user/add")
    public ModelAndView createUser(ModelAndView modelAndView) {
        modelAndView.setViewName("create");
        modelAndView.addObject("user", new UserModel());
        return modelAndView;
    }

    @PostMapping(value = "/user/add")
    public ModelAndView createUser(@ModelAttribute UserModel user, ModelAndView modelAndView) {
        modelAndView.setViewName("create");
        modelAndView.addObject("user", userService.create(user));
        return modelAndView;
    }

    @GetMapping("/user/{id}")
    public ModelAndView get(@PathVariable("id") Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("getUser");
        modelAndView.addObject("getUser", userService.getById(id));
        return modelAndView;
    }

    @PutMapping("/user/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @ModelAttribute UserModel user, ModelAndView modelAndView) {
        user.setId(id);
        modelAndView.setViewName("update");
        modelAndView.addObject("update", userService.update(user));
        return modelAndView;
    }

    @DeleteMapping("/user/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("delete");
        userService.delete(id);
        return modelAndView;
    }

    @GetMapping("/admin")
    public String showAdmin(Principal principal) {
        utils.getUser(principal);
        return "admin";
    }
}
