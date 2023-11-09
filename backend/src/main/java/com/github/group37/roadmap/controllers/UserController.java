package com.github.group37.roadmap.controllers;

import com.github.group37.roadmap.Models.User;
import com.github.group37.roadmap.Models.UserRequest;
import com.github.group37.roadmap.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User postUser(@RequestBody UserRequest userRequest){
        User user = new User(UUID.randomUUID(), userRequest.getName(), userRequest.getPassword());
        return userService.createUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.readUser();
    }

    @PutMapping("/")
    public User updateUser(UUID id, @RequestBody UserRequest updatedUserDetails){
        return userService.updateUser(id, updatedUserDetails.getName(),updatedUserDetails.getPassword());
    }

    @DeleteMapping("/")
    public void deleteUser(UUID id){
        userService.deleteUser(id);
    }

}