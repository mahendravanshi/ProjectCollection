package com.fordTest1.VehicleAPI.controller;

import com.fordTest1.VehicleAPI.model.Customer;
import com.fordTest1.VehicleAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }


}


