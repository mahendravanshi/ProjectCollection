package com.mine.controller;
import com.mine.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mine.entity.User;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void saveUser() {
        User userToSave = new User(1, "John Doe", 25, "123 Main Street");
        User savedUser = new User(1, "John Doe", 25, "123 Main Street");

        when(userService.addUser(userToSave)).thenReturn(savedUser);

        User result = userController.saveUser(userToSave);

        assertEquals(savedUser, result);
        verify(userService, Mockito.times(1)).addUser(userToSave);
    }

    @Test
    void findAllUsers() {
        List<User> userList = Arrays.asList(
                new User(1, "John Doe", 25, "123 Main Street"),
                new User(2, "Jane Doe", 30, "456 Side Street")
        );

        when(userService.getUsers()).thenReturn(userList);

        List<User> result = userController.findAllUsers();

        assertEquals(userList, result);
        verify(userService, Mockito.times(1)).getUsers();
    }

    @Test
    void findUserByAddress() {
        String address = "123 Main Street";
        List<User> userList = Arrays.asList(
                new User(1, "John Doe", 25, address),
                new User(2, "Jane Doe", 30, address)
        );

        when(userService.findByAddress(address)).thenReturn(userList);

        List<User> result = userController.findUserByAddress(address);

        assertEquals(userList, result);
        verify(userService, Mockito.times(1)).findByAddress(address);
    }

    // Similar tests for removeUser and getById methods can be written


}
