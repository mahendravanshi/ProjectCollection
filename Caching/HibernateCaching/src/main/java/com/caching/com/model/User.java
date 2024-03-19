package com.caching.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "users")
@Entity
public class User {

      @Id
      private Integer id;
      private String email;
      private String name;
      private String password;

}









