package com.fordTest1.TDDTesting1.repository;

import com.fordTest1.TDDTesting1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    List<Customer> findByAge(Integer age);

}
