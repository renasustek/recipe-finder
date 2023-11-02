package com.github.group37.roadmap.controllers;

import com.github.group37.roadmap.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/login")
    public User String(){

    }
}