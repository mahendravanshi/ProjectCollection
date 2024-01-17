package com.testing.service;

import com.testing.repo.PersonRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepo personRepo;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    void setup(){
        this.personService = new PersonService(this.personRepo);
    }

    @Test
    void getAllPerson() {

           personService.getAllPerson();

           verify(personRepo).findAll();
    }


}