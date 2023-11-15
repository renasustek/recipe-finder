package com.github.group37.roadmap.service;

import com.github.group37.roadmap.models.User;
import com.github.group37.roadmap.models.UserRequest;
import com.github.group37.roadmap.percistance.UserRepositiory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepositiory userRepositiory;
    
    public UserService(UserRepositiory userRepositiory) {
        this.userRepositiory = userRepositiory;
    }

    public User create(UserRequest userRequest){
        User user = new User(UUID.randomUUID(), userRequest.name(), userRequest.password());
        return userRepositiory.save(user);
    }
    public List<User> readAll(){
        return userRepositiory.findAll();
    }

    public Optional<User> update(UUID userID, String updatedName, String updatedPassword){
          return userRepositiory.findById(userID).map(user->{
              user.setName(updatedName);
              user.setPassword(updatedPassword);
              return userRepositiory.save(user);
          });
    }

    public Optional<User> findById(UUID id){
         return userRepositiory.findById(id);
    }

    public void delete(UUID userId){
        try {
            userRepositiory.deleteById(userId);
        } catch (Exception ex){

        }

    }
}
