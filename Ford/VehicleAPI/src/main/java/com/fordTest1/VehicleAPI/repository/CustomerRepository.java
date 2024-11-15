package com.fordTest1.VehicleAPI.repository;

import com.fordTest1.VehicleAPI.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
