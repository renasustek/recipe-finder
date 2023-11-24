package com.github.group37.roadmap.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.group37.roadmap.models.User;
import com.github.group37.roadmap.models.UserRequest;
import com.github.group37.roadmap.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Autowired
    private ObjectMapper objectMapper;


    private User user1 = new User(UUID.randomUUID(),"abdi","smith");
    private UserRequest userRequest1 = new UserRequest("abdi","smith");
    private UserRequest userRequestValidUnameAndPw = new UserRequest("changed","changed");
    private UserRequest longUserRequest = new UserRequest("aaaaaaaaaaaaaaaaaaaaLongerThan36Charsaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaLongerThan36Charsaaaaaaaaaaaaaaaaaaaa");
    private UserRequest shortUserRequest = new UserRequest("he","he");
    @Test
    void ShouldGetListOfUsersSuccessfully() throws Exception {
        when(service.readAll()).thenReturn(List.of(user1));
        this.mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(user1.getId().toString()))
                .andExpect(jsonPath("$[0].name").value(user1.getUsername()))
                .andExpect(jsonPath("$[0].password").value(user1.getPassword()));
    }

    @Test
    void ShouldCreateAndReturnUserSuccsesfully() throws Exception{
        when(service.create(userRequest1)).thenReturn(user1);
        this.mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest1))
                        .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(user1.getId().toString()))
                .andExpect(jsonPath("$.name").value(user1.getUsername()))
                .andExpect(jsonPath("$.password").value(user1.getPassword()))
        ;
    }

    @Test
    void WhenGivenIdAndUserIsFound() throws Exception{
        when(service.findById(user1.getId())).thenReturn(Optional.of(user1));
        this.mockMvc.perform(get("/users/"+user1.getId())
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user1.getId().toString()))
                .andExpect(jsonPath("$.name").value(user1.getUsername()))
                .andExpect(jsonPath("$.password").value(user1.getPassword()));
    }

    @Test
    void WhenGivenIdAndUserIsNotFound() throws Exception {
        when(service.findById(user1.getId())).thenReturn(Optional.empty());
        this.mockMvc.perform(get("/users/"+user1.getId())
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());

    }

    @Test
    void shouldUpdateUser() throws Exception {
        User updatedUser = new User(user1.getId(), userRequestValidUnameAndPw.name(), userRequestValidUnameAndPw.password());
        when(service.update(user1.getId(), userRequestValidUnameAndPw.name(), userRequestValidUnameAndPw.password())).thenReturn(Optional.of(updatedUser));
        this.mockMvc.perform(put("/users/"+updatedUser.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestValidUnameAndPw))
                        .characterEncoding("utf-8")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(updatedUser.getId().toString()))
                .andExpect(jsonPath("$.name").value(updatedUser.getUsername()))
                .andExpect(jsonPath("$.password").value(updatedUser.getPassword()));
    }@Test
    void shouldNotUpdateNonExistingUser() throws Exception {
        when(service.update(user1.getId(), userRequestValidUnameAndPw.name(), userRequestValidUnameAndPw.password())).thenReturn(Optional.empty());
        this.mockMvc.perform(put("/users/"+user1.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user1))
                        .characterEncoding("utf-8")
                )
                .andExpect(status().isNotFound());
    }
    @Test
    void shouldNotUpdateUserWhenChosenNameAndPasswordIsTooLong() throws Exception {
        User updatedUser = new User(user1.getId(), longUserRequest.name(), longUserRequest.password());
        when(service.update(user1.getId(), longUserRequest.name(), longUserRequest.password())).thenThrow(new TransactionSystemException("500"));
        this.mockMvc.perform(put("/users/"+updatedUser.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(longUserRequest))
                        .characterEncoding("utf-8")
                )
                .andExpect(status().isBadRequest());

    }
    @Test
    void shouldNotUpdateUserWhenNameAndPasswordIsTooShort() throws Exception {
        User updatedUser = new User(user1.getId(), shortUserRequest.name(), shortUserRequest.password());
        when(service.update(user1.getId(), shortUserRequest.name(), shortUserRequest.password())).thenThrow(new TransactionSystemException("500"));
        this.mockMvc.perform(put("/users/"+updatedUser.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shortUserRequest))
                        .characterEncoding("utf-8")
                )
                .andExpect(status().isBadRequest());

    }

    @Test
    void givenUserId_whenDeleteCalled_returnNothing() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.delete("/users/{id}", user1.getId()))
            .andExpect(status().isOk());
    }
}

