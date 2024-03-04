package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Data

public class Employee {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     private String name;
     private String email;


}
