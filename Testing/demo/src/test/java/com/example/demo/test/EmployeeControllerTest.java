package com.example.demo.test;

import controller.EmployeeController;
import entity.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import repo.EmpRepo;
import service.EmployeeService;

import static org.mockito.Mockito.when;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

          @Autowired
          private MockMvc mockMvc;

          @Mock
         EmployeeService employeeService;

          @Test
         void getEmployeeByEmailTest() throws Exception {

              Employee emp = new Employee(1,"mahendra","m@gmail.com");

              when(employeeService.getEmployeeByEmail("m@gmail.com")).thenReturn(emp);

//              mockMvc.perform(MockMvcRequestBuilders.get("/getEmp/{email}","m@gmail.com")).andExpect(MockMvcResultMatchers())



          }


}
