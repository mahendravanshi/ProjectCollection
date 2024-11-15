package com.learn.repo;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class BookRepoTest {

      @Autowired
      private TestEntityManager testEntityManager;

      @Autowired
      private BookRepo bookRepo;

      @BeforeEach
      public void setup(){


      }
}
