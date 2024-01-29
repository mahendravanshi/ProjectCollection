package com.example.demo.serviceTest;

import com.example.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.repo.EmpRepo;
import com.example.demo.service.EmployeeService;

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

          Employee expEmp = employeeService.findEmployeeByEmail(emp.getEmail());

          Assertions.assertEquals(emp,expEmp);

      }



}
