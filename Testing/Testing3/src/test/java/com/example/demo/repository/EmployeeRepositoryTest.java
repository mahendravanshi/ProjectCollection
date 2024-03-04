package com.example.demo.repository;


import com.example.demo.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.example.demo.repo.EmpRepo;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeRepositoryTest {

    @MockBean
    private EmpRepo empRepo;


    @Autowired
    private TestEntityManager testEntityManager;


      @Test
       public void saveEmployee(){
            Employee e = Employee.builder()
                    .email("abc@gmail.com")
                    .name("abc")
                    .build();
            Employee emp = empRepo.save(e);

            Assertions.assertThat(emp).isNotNull();

//            Assertions.assertThat(emp.getId()).isNotNull();


            Assertions.assertThat(e.getEmail())
                    .isEqualTo(emp.getEmail());

            Assertions.assertThat(e.getName())
                    .isEqualTo(emp.getName());

//          Employee e = Employee.builder()
//                  .email("abc@gmail.com")
//                  .name("abc")
//                  .build();
//
//          // Save the entity using TestEntityManager
//          Employee savedEmployee = testEntityManager.persist(e);
//
//          // Flush the changes to the database
//          testEntityManager.flush();
//
//          // Clear the persistence context to simulate a new transaction
//          testEntityManager.clear();
//
//          // Retrieve the entity from the database
//          Employee retrievedEmployee = empRepo.findById(savedEmployee.getId()).orElse(null);
//
//          // Perform assertions
//          Assertions.assertThat(retrievedEmployee).isNotNull();
//          Assertions.assertThat(retrievedEmployee.getEmail()).isEqualTo("abc@gmail.com");
//          Assertions.assertThat(retrievedEmployee.getName()).isEqualTo("abc");


       }


       @Test
       public void getEmployeeByEmail(){

           Employee e = Employee.builder()
                   .email("abc@gmail.com")
                   .name("abc")
                   .build();

//          BDDMockito.given(empRepo.findEmployeeByEmail(e.getEmail()))
//                   .willReturn(e);

           Employee res = empRepo.findEmployeeByEmail(e.getEmail());

//           Assertions.assertThat(res.getId()).isNotNull();

           Assertions.assertThat(e.getEmail()).isEqualTo(res.getEmail());

           Assertions.assertThat(res).isEqualTo(e);


       }

//public void getEmployeeByEmail() {
//    // Given
//    Employee e = Employee.builder()
//            .email("abc@gmail.com")
//            .name("abc")
//            .build();
//
//    // Mocking repository method behavior
//    BDDMockito.given(empRepo.findEmployeeByEmail(e.getEmail())).willReturn(e);
//
//
//        // When
//        Employee res = empRepo.findEmployeeByEmail(e.getEmail());
//
//        // Then
//        // Verify that the repository method is called exactly once with the provided email
//        BDDMockito.verify(empRepo, BDDMockito.times(1)).findEmployeeByEmail(e.getEmail());
//
//        // Assertions
//        Assertions.assertThat(res).isNotNull();
//
//        Assertions.assertThat(res.getEmail()).isEqualTo("abc@gmail.com");
//        Assertions.assertThat(res.getName()).isEqualTo("abc");
//        Assertions.assertThat(res).isEqualTo(e);
//
//
//    }



}
