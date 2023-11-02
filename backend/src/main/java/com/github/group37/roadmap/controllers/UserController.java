package com.github.group37.roadmap.controllers;

import com.github.group37.roadmap.Models.User;
import com.github.group37.roadmap.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.readUser();
    }
}