package com.mine.service;

import com.mine.entity.User;
import com.mine.exception.UserNotFoundException;
import com.mine.repo.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserNotFoundException userNotFoundException;

    private static User getUserDetails() {
        return new User(1, "John Doe", 25, "123 Main Street");
    }

    @Test
    void addUser() {
        when(userRepository.save(getUserDetails())).thenReturn(getUserDetails());

        assertEquals("John Doe", userService.addUser(getUserDetails()).getName());
    }


    @Test
    void getUsers() {

        when(userRepository.findByAddress(getUserDetails().getAddress())).thenReturn(Collections.singletonList(getUserDetails()));
        User response = userService.findById(getUserDetails().getId());
        Assertions.assertNotNull(getUserDetails().getId());

        assertEquals(getUserDetails(), userService.findById(1));

    }

    @Test
    void getUserbyAddress() {

        when(userRepository.findByAddress("123 Main Street")).thenReturn(List.of(getUserDetails()));

        assertEquals("123 Main Street", getUserDetails().getAddress());
    }


    @Test
    void deleteUser() {

        doNothing().when(userRepository).delete(any(User.class));

        assertEquals("User Removed",userService.deleteUser(getUserDetails()));
    }

    @Test
    void findById() {

        when(userRepository.findById(getUserDetails().getId())).thenReturn(Optional.of(getUserDetails()));
        User foundUser = userService.findById(getUserDetails().getId());
        assertNotNull(foundUser);
        assertEquals(getUserDetails(), foundUser);
    }


    @Disabled
    @DisplayName("When Id is not present in Repository")
    @Test
    public void findByIdException(){
        User user1 = new User(1, "Doug", 21,"123 Church Street");
        Assertions.assertThrows(UserNotFoundException.class, ()-> userService.findById(user1.getId()));
    }







}