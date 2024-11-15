package com.unit_testing.Unit_testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.unit_testing.Unit_testing.controller.UserController;
import com.unit_testing.Unit_testing.entity.User;
import com.unit_testing.Unit_testing.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(UserControllerTest.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    User user1 = new User(1, "susheel", "sushil@gmail.com", "1234567890");
    User user2 = new User(2, "rupesh", "rupesh@gmail.com", "1234567890");
    User user3 = new User(3, "sparsh", "sparsh@gmail.com", "1234567890");

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testAllUser() throws Exception {
        List<User> list = new ArrayList<>(Arrays.asList(user1, user2, user3));

        Mockito.when(userService.getUsers()).thenReturn(list);
        ResponseEntity<List<User>> allUser = userController.getAllUser();
        Assertions.assertEquals(allUser.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(allUser.getBody().size(), list.size());
        Assertions.assertEquals(allUser.getBody().get(0).getId(), list.get(0).getId());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("susheel")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("rupesh")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name", Matchers.is("sparsh")));
    }

    @Test
    public void testSaveUser_success() throws Exception {
        User user = new User();
        user.setId(2);
        user.setName("Susheel");
        user.setMobile("89849734779");
        user.setEmail("sushil@gmail.com");

        Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(user);

        String userJson = objectWriter.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Susheel")));
    }

    @Test
    public void check_success() throws Exception {

        ResultActions req = mockMvc.perform(MockMvcRequestBuilders.post("/check/{fName}", "Susheel")
                .param("lName", "Kumar"));
        req.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Susheel")));
    }

    @Test
    public void delete_user(){
        Integer id = 1;
        userService.deleteUser(id);
        Mockito.verify(userService, Mockito.times(1)).deleteUser(1);
    }
}
