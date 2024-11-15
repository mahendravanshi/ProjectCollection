package com.fordTest1.VehicleAPI.service;


import com.fordTest1.VehicleAPI.model.Customer;
import com.fordTest1.VehicleAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public Customer addCustomer(Customer customer) {
        return customer;
    }


}

