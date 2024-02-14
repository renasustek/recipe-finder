package com.github.group37.roadmap.controllers;

import com.github.group37.roadmap.errors.UserNotFoundException;
import com.github.group37.roadmap.other.UserRequest;
import com.github.group37.roadmap.percistance.models.User;
import com.github.group37.roadmap.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody UserRequest userRequest) {
        User createdUser = userService.create(userRequest);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getUuid()))
                .body(createdUser);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.readAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable UUID id) {
        return userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    } // TODO test delete

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User update(@PathVariable UUID id, @RequestBody UserRequest updatedUserDetails) {
        return userService
                .update(id, updatedUserDetails.name(), updatedUserDetails.password())
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}