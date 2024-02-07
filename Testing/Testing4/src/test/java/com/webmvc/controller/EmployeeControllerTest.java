package com.webmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webmvc.entity.Employee;
import com.webmvc.service.EmployeeService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

     @Autowired
    MockMvc mockMvc;

     @MockBean
    EmployeeService employeeService;

     @Autowired
    ObjectMapper objectMapper;

                 @Disabled
                 @Test
                 void testAddEmployee() throws Exception{
                     Employee passed = Employee.builder().fName("ab").lName("ba").email("ab@gmail.com").build();
                             mockMvc.perform(
                              MockMvcRequestBuilders.post("/employees")
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(objectMapper.writeValueAsString(passed))
                                      .accept(MediaType.APPLICATION_JSON)
                             )
                                     .andExpect(status().isCreated());
            ////                         .andExpect(MockMvcResultMatchers.jsonPath("$.*").isNotEmpty())
            //                         .andExpect(MockMvcResultMatchers.jsonPath("$.fName").value(passed.getFName()))
            //                         .andExpect(MockMvcResultMatchers.jsonPath("$.lName").value(passed.getLName()))
            //                         .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(passed.getEmail()));


                 }

                 @Test
                 void getEmployeeByIdTest() throws Exception {

                      mockMvc.perform(
                              MockMvcRequestBuilders.get("/employees/{id}",1)
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .accept(MediaType.APPLICATION_JSON)

                      )
                              .andExpect(status().isOk());
//                              .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));


                 }



}
