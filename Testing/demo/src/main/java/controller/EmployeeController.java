package controller;


import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;


     @GetMapping("/getEmp/{email}")

       public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable  String email){

            return new ResponseEntity<>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
       }



}
