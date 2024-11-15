package com.ford.service;


import com.ford.model.Employee;
import com.ford.repo.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;


    @InjectMocks
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
    public void addEmployeeTest() {


        Employee em = Employee.builder().id(1).name("ABC").department("React").build();
        Mockito.when(employeeRepository.save(em)).thenReturn(em);

        Employee savedEmployee = employeeService.addEmployee(em);

        Assertions.assertEquals(employeeService.addEmployee(em), savedEmployee);
        Assertions.assertEquals(em.getDepartment(), savedEmployee.getDepartment());
        Assertions.assertEquals(em.getId(), savedEmployee.getId());

    }

    @Test
    public void getById() {
        Employee em = Employee.builder().id(1).name("ABC").department("React").build();

        Integer id = 1;
        Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.ofNullable(em));

        Employee returnedEmployee = employeeRepository.findById(1).get();

        Assertions.assertEquals(em, returnedEmployee);
        Assertions.assertEquals(em.getName(), returnedEmployee.getName());

    }


    @Test
    public void getAllTest() {

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> expected = employeeRepository.findAll();

        Assertions.assertEquals(employees, expected);
        Assertions.assertEquals(employees.get(0).getName(), expected.get(0).getName());
        Mockito.verify(employeeRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void findByIdException(){
          
         Integer id = 10;
           Mockito.when(employeeRepository.findById(id)).thenThrow(
               new RuntimeException("User not found with user id "+id)
           );

           RuntimeException re = Assertions.assertThrows(RuntimeException.class,()->{
               employeeService.findById(id);
           });

           Assertions.assertEquals(re.getMessage(),"User not found with user id "+id);

    }

    @Test
    void deleteByIdException() {
        Integer id = 14;

        Mockito.doThrow(new RuntimeException("User not found")).when(employeeRepository).deleteById(id);

        Assertions.assertThrows(RuntimeException.class, () -> {
            employeeService.deleteById(id);
        });
    }





}
