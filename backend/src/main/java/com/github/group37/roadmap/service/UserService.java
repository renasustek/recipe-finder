package com.github.group37.roadmap.service;

import com.github.group37.roadmap.percistance.models.User;
import com.github.group37.roadmap.other.UserRequest;
import com.github.group37.roadmap.percistance.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserRequest userRequest){
        User user = new User(UUID.randomUUID(),userRequest.name(), userRequest.password(),true);
        return userRepository.save(user);
    }
    public List<User> readAll(){
        return userRepository.findAll();
    }

    public Optional<User> update(UUID userID, String updatedName, String updatedPassword){
          return userRepository.findById(userID).map(user->{
              user.setUsername(updatedName);
              user.setPassword(updatedPassword);
              return userRepository.save(user);
          });
    }

    public Optional<User> findById(UUID id){
         return userRepository.findByUUID(id);
    }

    public void delete(UUID userId){
            userRepository.deleteById(userId);
    }
}
