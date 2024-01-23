package com.testing.service;


import com.testing.entity.Person;
import com.testing.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }


    public List<Person> getAllPerson(){
        return personRepo.findAll();
    }


}
