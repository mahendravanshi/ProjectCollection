package com.ford.fordScenario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.fordScenario.model.User;
import com.ford.fordScenario.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@WebMvcTest(UserController.class)
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;


    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        UUID uid = UUID.randomUUID();
        user.setId(uid);
        user.setFullName("ABC BCD");
        user.setTotalRides(10);
        user.setRegisteredDate(LocalDate.now());

    }


    @Test
    void registerUserTest() throws Exception {

        Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(user);

        User expectedUser = userController.registerUser(user).getBody();


        var perform = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)
        );


        perform.andExpect(MockMvcResultMatchers.jsonPath("$.fullName", Matchers.is("ABC BCD")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.registeredDate").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalRides", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Assertions.assertEquals(expectedUser.getFullName(),"ABC BCD");
        assertThat(expectedUser.getId()).isNotNull();


    }









}
