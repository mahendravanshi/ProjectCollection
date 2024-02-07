package com.webmvc.service;

import com.webmvc.entity.Employee;
import com.webmvc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addUser(Employee employee) {
        return employeeRepository.save(employee);

    }

    public Employee getById(int id) {

        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("No employee found to by id"+id));

    }

    public Employee updateEmployee(Integer id, Employee employee)  {
        Employee existingEmp = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("No employee found with id to update "+ id));
        employee.setId(id);
        return employeeRepository.save(employee);

    }


    public Employee deleteEmployee(int id) {

       Employee emp =   employeeRepository.findById(id).orElseThrow(()->new RuntimeException("No employee found to delete by id"+id));

        employeeRepository.deleteById(id);
        return emp;
    }


    public List<Employee> getAllEmployees() {
        List<Employee> list = employeeRepository.findAll();

        if(list.size()==0){
            throw new RuntimeException("No employee found");
        }

        return list;
    }




}
