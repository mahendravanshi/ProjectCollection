package service;

import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.EmpRepo;

@Service
public class EmployeeService {

      @Autowired
      private EmpRepo empRepo;

      public Employee getEmployeeByEmail(String email){

            return empRepo.findEmployeeByEmail(email);
      }



}
