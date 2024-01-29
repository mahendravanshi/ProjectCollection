package com.example.demo.test;

import com.example.demo.controller.EmployeeController;
import com.example.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

          @Autowired
          private MockMvc mockMvc;

          @Mock
         EmployeeService employeeService;

          @Test
         void getEmployeeByEmailTest() throws Exception {

              Employee emp = new Employee(1,"mahendra","m@gmail.com");

//              when(employeeService.getEmployeeByEmail("m@gmail.com")).thenReturn(emp);

//              mockMvc.perform(MockMvcRequestBuilders.get("/getEmp/{email}","m@gmail.com")).andExpect(MockMvcResultMatchers())



          }


}
