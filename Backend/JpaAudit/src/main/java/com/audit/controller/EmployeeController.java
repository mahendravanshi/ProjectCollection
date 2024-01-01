package com.audit.controller;

import com.audit.dto.InputRequest;
import com.audit.model.Employee;
import com.audit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody InputRequest<Employee> req){

       return employeeService.saveEmployee(req);

    }

    @PutMapping("/update/{id}/{salary}")
    public Employee updateEmployee(@PathVariable Integer id,@PathVariable Double salary,@RequestBody InputRequest<Employee> req){

           return employeeService.updateEmployee(id,salary,req);
    }



}
