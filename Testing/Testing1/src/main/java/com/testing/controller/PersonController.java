package com.testing.controller;


import com.testing.entity.Person;
import com.testing.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPerson(){
        return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.OK);
    }
}
