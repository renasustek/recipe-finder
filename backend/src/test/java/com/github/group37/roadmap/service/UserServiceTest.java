package com.github.group37.roadmap.service;
// https://www.javaguides.net/2022/03/spring-boot-unit-testing-service-layer.html#:~:text=In%20order%20to%20test%20Service,a%20database%20for%20Unit%20testing.&text=The%20Spring%20Boot%20Starter%20Test,testing%20the%20Spring%20Boot%20Applications.

import com.github.group37.roadmap.other.UserRequest;
import com.github.group37.roadmap.percistance.UserRepository;
import com.github.group37.roadmap.percistance.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepositiory;

    @InjectMocks
    private UserService userService;

    private final User user = new User(UUID.randomUUID(), "chandler", "bing");
    private final UserRequest userRequest = new UserRequest("chandler", "bing");

    private final UserRequest updateUserRequest = new UserRequest("Joey", "Tribbiani");

    @DisplayName("Should create and return a user succesfully")
    @Test
    public void givenUserObject_whenCreatingUser_returnsUser() {
        given(userRepositiory.save(any())).willReturn(user);

        User savedUser = userService.create(userRequest);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo(userRequest.name());
        assertThat(savedUser.getPassword()).isEqualTo(userRequest.password());
    }

    @DisplayName("should return a list of all users")
    @Test
    public void shouldReturnListOfAllUsers() {
        given(userRepositiory.findAll()).willReturn(List.of(user));

        List<User> users = userService.readAll();

        assertThat(users.get(0).getId()).isNotNull();
        assertThat(users.get(0).getUsername()).isEqualTo(user.getUsername());
        assertThat(users.get(0).getPassword()).isEqualTo(user.getPassword());
    }

    @DisplayName("should update user details")
    @Test
    public void whenGivenId_andUpdatedDetails_shouldReturnUserWithUpdatedDetails() {
        given(userRepositiory.findById(user.getId()))
                .willReturn(
                        Optional.of(new User(user.getId(), updateUserRequest.name(), updateUserRequest.password())));

        Optional<User> users = userService.update(user.getId(), updateUserRequest.name(), updateUserRequest.password());
        if (users.isPresent()) {
            assertThat(users.get().getId()).isNotNull();
            assertThat(users.get().getUsername()).isEqualTo(user.getUsername());
            assertThat(users.get().getPassword()).isEqualTo(user.getPassword());
        }
    }

    @DisplayName("shouldnt update user details")
    @Test
    public void whenInGivenId_andUpdatedDetails_shouldReturnEmptyOptional() {
        given(userRepositiory.findById(user.getId())).willReturn(Optional.empty());
        Optional<User> users = userService.update(user.getId(), updateUserRequest.name(), updateUserRequest.password());
        assertThat(users.isPresent()).isFalse();
    }

    @DisplayName("should return user when given ID")
    @Test
    public void whenGivenId_returnUser() {
        given(userRepositiory.findByUUID(user.getId())).willReturn(Optional.of(user));
        Optional<User> findUser = userService.findById(user.getId());

        assertThat(findUser.get().getId()).isNotNull();
        assertThat(findUser.get().getUsername()).isEqualTo(user.getUsername());
        assertThat(findUser.get().getPassword()).isEqualTo(user.getPassword());
    }

    @DisplayName("should not return user when given ID")
    @Test
    public void whenInvalidGivenId_returnEmptyOptional() {
        given(userRepositiory.findByUUID(user.getId())).willReturn(Optional.empty());
        Optional<User> findUser = userService.findById(user.getId());
        assertThat(findUser.isPresent()).isFalse();
    }

    @DisplayName("the delete returns nothing")
    @Test
    public void whenDeleteIsCalled_shouldCallRepository() {
        willDoNothing().given(userRepositiory).deleteById(user.getId());
        userService.delete(user.getId());
        verify(userRepositiory, times(1)).deleteById(user.getId());
    }
}
