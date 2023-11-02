package com.github.group37.roadmap.service;

import com.github.group37.roadmap.Models.User;
import com.github.group37.roadmap.percistance.UserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepositiory userRepositiory;


    @Autowired
    public UserService(UserRepositiory userRepositiory) {
        this.userRepositiory = userRepositiory;
    }

    public List<User> readUser(){
        return userRepositiory.findAll();
    }
}
