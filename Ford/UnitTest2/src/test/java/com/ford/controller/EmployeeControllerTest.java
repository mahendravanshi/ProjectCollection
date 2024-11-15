package com.ford.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.model.Employee;
import com.ford.service.EmployeeService;
import org.hamcrest.Matchers;
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

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    private List<Employee> employees = new ArrayList<>();

    @BeforeEach
    void setup() {
        Employee e1 = Employee.builder().id(1).name("ABC").department("Java").build();
        Employee e2 = Employee.builder().id(2).name("BCD").department("Python").build();
        Employee e3 = Employee.builder().id(3).name("CDE").department("React").build();

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
    }

    @Test
    public void addEmployeeTest() throws Exception {
        Employee employee = Employee.builder().id(1).name("ABC").department("Java").build();

        Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("ABC")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));
    }


    @Test
    public void getByIdTest() throws Exception{

        Employee employee = Employee.builder().id(1).name("ABC").department("Java").build();

        Mockito.when(employeeService.findById(1)).thenReturn(employee);

       var perform =  mockMvc.perform(MockMvcRequestBuilders.get("/employees/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
        );

        perform.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("ABC")))
                ;

    }


    @Test
    public void getAllTest() throws Exception {

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        var perform = mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                .contentType(MediaType.APPLICATION_JSON)
        );

          perform
                  .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(3)))
                  .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",Matchers.is("ABC")))
                  .andExpect(MockMvcResultMatchers.jsonPath("$[2].department",Matchers.is("React")));


    }

    @Test
    public void deleteByIdTest() throws Exception {
           int id = 1;
           String str = "Data deleted successfully";
           Mockito.when(employeeService.deleteById(id)).thenReturn(str);

          var perform =  mockMvc.perform(MockMvcRequestBuilders.delete("/employees/{id}",id)
                   .contentType(MediaType.APPLICATION_JSON)
           );

          perform
                  .andExpect(MockMvcResultMatchers.status().isOk())
                  .andExpect(MockMvcResultMatchers.content().string(str));
    }




}
