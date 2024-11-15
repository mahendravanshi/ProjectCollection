package com.fordTest1.TDDTesting1.service;

import com.fordTest1.TDDTesting1.exception.CustomException;
import com.fordTest1.TDDTesting1.exception.ResourceNotFoundException;
import com.fordTest1.TDDTesting1.model.Customer;
import com.fordTest1.TDDTesting1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public List<Customer> getAll(Integer age, String city) {
        // Retrieve all customers from the repository
        List<Customer> allCustomers = customerRepository.findAll();


        // Apply filtering if age or city is provided
        return allCustomers.stream()
                .filter(customer -> (age == null || customer.getAge().equals(age)) &&
                        (city == null || customer.getCity().equals(city)))
                .collect(Collectors.toList());
    }


    public void deleteById(UUID id) {
          if(!customerRepository.existsById(id)){
              throw new ResourceNotFoundException("No record found to delete");
          }

          customerRepository.deleteById(id);
    }


    public Customer getById(UUID id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("No record found");
        }
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found"));
    }


    public Boolean existsById(UUID id){
        return customerRepository.existsById(id);
    }

}
