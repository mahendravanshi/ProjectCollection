package com.webmvc.controller;

import com.webmvc.entity.Employee;
import com.webmvc.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

     //add Employee
      @PostMapping("/employees")
     public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){

           return new ResponseEntity<>(employeeService.addUser(employee), HttpStatus.CREATED);
      }


      //find Employee By Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") int id)
    {
        return new ResponseEntity<>(employeeService.getById(id),HttpStatus.OK);
    }

    // get All Employees
    @GetMapping("/employees")
     public ResponseEntity<List<Employee>> getAllEmployees(){
          return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

      //Update Employee By id
      @PutMapping("/employees/{id}")
     private ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@Valid @RequestBody Employee employee){
          return new ResponseEntity<>(employeeService.updateEmployee(id,employee),HttpStatus.ACCEPTED);
      }

      // Delete Employee By Id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> removeEmployee (@PathVariable("id") int id)
    {
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }




}
