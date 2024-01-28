package com.example.demo.serviceTest;

import entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import repo.EmpRepo;
import service.EmployeeService;

import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

      @Mock
      private EmpRepo empRepo;

      @InjectMocks
      private EmployeeService employeeService;

      @Test
      void getEmployeeByEmailTest(){

          Employee emp = new Employee(1,"Mahendra","m@gmail.com");

          when(empRepo.findEmployeeByEmail("m@gmail.com")).thenReturn(emp);


          Employee expEmp = employeeService.getEmployeeByEmail("m@gmail.com");


          Assertions.assertEquals(emp,expEmp);



      }


}
