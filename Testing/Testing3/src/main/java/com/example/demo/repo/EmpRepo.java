package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

      Employee findEmployeeByEmail(String email);
}
