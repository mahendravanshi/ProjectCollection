package com.learn.controller;


import com.learn.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

       @GetMapping("/")
       public List<Customer> getAllCustomers() throws InterruptedException {

           return customerService.loadAllCustomers();
       }


}
