package com.github.group37.roadmap.service;

import com.github.group37.roadmap.Models.User;
import com.github.group37.roadmap.percistance.UserRepositiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepositiory userRepositiory;


    @Autowired
    public UserService(UserRepositiory userRepositiory) {
        this.userRepositiory = userRepositiory;
    }

    public User createUser(User user){
        return userRepositiory.save(user);
    }
    public List<User> readAllUsers(){
        return userRepositiory.findAll();
    }

    public User updateUser(UUID userID, String updatedName, String updatedPassword){
        User userToUpdate = userRepositiory.getReferenceById(userID);
        userToUpdate.setName(updatedName);
        userToUpdate.setPassword(updatedPassword);
        return userRepositiory.save(userToUpdate);
    }

    public void deleteUser(UUID userId){
        userRepositiory.deleteById(userId);
    }
}
