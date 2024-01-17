package com.testing.repo;

import com.testing.entity.Person;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;


    @Test
    void existsByPersonId() {

        Person person = Person.builder().personId(1).personName("Mahendra").personCity("Indore").build();
        personRepo.save(person);

        Boolean res = personRepo.existsByPersonId(1);

        assertThat(res).isTrue();


    }

     @AfterEach
     void tearDown(){

          personRepo.deleteAll();
     }

     @BeforeEach
    void setup(){

     }


}