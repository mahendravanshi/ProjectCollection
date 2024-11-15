package com.ford.service;


import com.ford.model.Employee;
import com.ford.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public String deleteById(Integer id) {
          employeeRepository.deleteById(id);
          return "employee deleted successfully";
    }
}
