package com.fordTest1.TDDTesting1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

     @Id
//     @GeneratedValue(strategy= GenerationType.IDENTITY)
     private UUID id;


     private String bookName;

     private String author;


}
