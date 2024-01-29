package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repo.EmpRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

      @Autowired
      private EmpRepo employeeRepository;



      public EmployeeService(EmpRepo employeeRepository) {
            this.employeeRepository = employeeRepository;
      }

      public Employee saveEmployee(Employee employee) {
            return employeeRepository.save(employee);
      }

      public Employee findEmployeeByEmail(String email){
           return employeeRepository.findEmployeeByEmail(email);
      }


      public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
      }


      public Optional<Employee> getEmployeeById(Integer id) {
            return employeeRepository.findById(id);
      }


      public void deleteEmployee(Integer id) {
            employeeRepository.deleteById(id);
      }

      public Employee findById(Integer id) {
            return employeeRepository.findById(id).get();
      }
}
