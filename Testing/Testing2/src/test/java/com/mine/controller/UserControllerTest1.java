package com.mine.controller;

import com.mine.controller.UserController;
import com.mine.entity.User;
import com.mine.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void saveUser() throws Exception {
        User userToSave = new User(1, "John Doe", 25, "123 Main Street");
        User savedUser = new User(1, "John Doe", 25, "123 Main Street");

        Mockito.when(userService.addUser(userToSave)).thenReturn(savedUser);

        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John Doe\",\"age\":25,\"address\":\"123 Main Street\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"John Doe\",\"age\":25,\"address\":\"123 Main Street\"}"));
    }



    @Test
    void findAllUsers() throws Exception {
        User user1 = new User(1, "John Doe", 25, "123 Main Street");
        User user2 = new User(2, "Jane Doe", 30, "456 Side Street");

        Mockito.when(userService.getUsers()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(MockMvcRequestBuilders.get("/getUsers")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"John Doe\",\"age\":25,\"address\":\"123 Main Street\"}," +
                        "{\"id\":2,\"name\":\"Jane Doe\",\"age\":30,\"address\":\"456 Side Street\"}]"));
    }

    // Similar tests for findUserByAddress, removeUser, and getById can be written
}

