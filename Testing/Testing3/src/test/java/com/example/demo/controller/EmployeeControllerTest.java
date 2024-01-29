package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.demo.service.EmployeeService;



@WebMvcTest
public class EmployeeControllerTest {

       @Autowired
       MockMvc mockMvc;

       @MockBean
       EmployeeService employeeService;

      @Autowired
      ObjectMapper objectMapper;

    @Test
    public void saveEmployeeTest() throws Exception {
        Employee emp = Employee.builder()
                .id(1)
                .email("abc@gmail.com")
                .name("abc")
                .build();

        BDDMockito.given(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/employees/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp)));

        response.andExpect(MockMvcResultMatchers.status().isOk());

    }

}