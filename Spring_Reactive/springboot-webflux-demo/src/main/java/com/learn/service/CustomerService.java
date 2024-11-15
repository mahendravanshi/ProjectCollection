package com.learn.service;


import com.learn.dao.CustomerDao;
import com.learn.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

       @Autowired
       private CustomerDao customerDao;

       public List<Customer> loadAllCustomers() throws InterruptedException {
           long start = System.currentTimeMillis();
           List<Customer> customers =  customerDao.getCustomers();
           long end = System.currentTimeMillis();
           System.out.println("Time taken: "+(end-start));
           return customers;
       }
}
