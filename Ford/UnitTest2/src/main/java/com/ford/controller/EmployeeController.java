package com.ford.controller;


import com.ford.model.Employee;
import com.ford.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


   @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
       return new ResponseEntity<>(employeeService.addEmployee(emp), HttpStatus.CREATED);
   }

   @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
       return new ResponseEntity<>(employeeService.findById(id),HttpStatus.FOUND);
   }

   @GetMapping
    public ResponseEntity<List<Employee>> findAll(){

       return new ResponseEntity<>(employeeService.findAll(),HttpStatus.FOUND);
   }


   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
       return new ResponseEntity<>(employeeService.deleteById(id),HttpStatus.OK);
   }







}
