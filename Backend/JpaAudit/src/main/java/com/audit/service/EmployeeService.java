package com.audit.service;


import com.audit.dto.Audit;
import com.audit.dto.InputRequest;
import com.audit.model.Employee;
import com.audit.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

     public Employee saveEmployee(InputRequest<Employee> req){

         String currentUser = req.getLoggedInUser();
         req.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
         Audit ad = Audit.builder().createdBy(currentUser).modifiedBy(currentUser).build();

         System.out.println(currentUser);
         Employee emp = req.getEmployee();
         return  employeeRepository.save(emp);

     }


     public Employee updateEmployee(Integer id,Double salary,InputRequest<Employee> req){
         Employee emp = employeeRepository.findById(id).get();

          emp.setSalary(salary);
         return employeeRepository.save(emp);

     }

}
