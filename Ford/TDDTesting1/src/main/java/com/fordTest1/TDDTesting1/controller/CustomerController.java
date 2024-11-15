package com.fordTest1.TDDTesting1.controller;


import com.fordTest1.TDDTesting1.model.Customer;
import com.fordTest1.TDDTesting1.service.CustomerService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

       @Autowired
      private CustomerService customerService;


       @PostMapping
       public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){

            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
       }

       @GetMapping
       public ResponseEntity<List<Customer>> getAll(@RequestParam(required = false) Integer age,@RequestParam(required = false) String city){

              return new ResponseEntity<>(customerService.getAll(age,city),HttpStatus.OK);
       }


       @DeleteMapping("/{id}")
       public ResponseEntity<Void> deleteById(UUID id){
           customerService.deleteById(id);
          return ResponseEntity.noContent().build();
       }

       @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable UUID id){
           return new ResponseEntity<>(customerService.getById(id),HttpStatus.FOUND);
       }



}
