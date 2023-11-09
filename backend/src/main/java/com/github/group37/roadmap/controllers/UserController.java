package com.github.group37.roadmap.controllers;

import com.github.group37.roadmap.Models.User;
import com.github.group37.roadmap.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/")
    public User postUser(@RequestBody User user){
        return userService.createUser(UUID.randomUUID(), );
    }

}