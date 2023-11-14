package com.github.group37.roadmap.service;
//https://www.javaguides.net/2022/03/spring-boot-unit-testing-service-layer.html#:~:text=In%20order%20to%20test%20Service,a%20database%20for%20Unit%20testing.&text=The%20Spring%20Boot%20Starter%20Test,testing%20the%20Spring%20Boot%20Applications.
import com.github.group37.roadmap.models.User;
import com.github.group37.roadmap.models.UserRequest;
import com.github.group37.roadmap.percistance.UserRepositiory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepositiory userRepositiory;

    @InjectMocks
    private UserService userService;

    private User user = new User(UUID.randomUUID(),"chandler","bing");
    private UserRequest userRequest = new UserRequest("chandler","bing");


    @DisplayName("Should create and return a user succesfully")
    @Test
    public void givenUserObject_whenCreatingUser_returnsUser(){
        given(userRepositiory.save(any())).willReturn(user);

        User savedUser = userService.create(userRequest);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo(userRequest.name());
        assertThat(savedUser.getPassword()).isEqualTo(userRequest.password());
    }

}