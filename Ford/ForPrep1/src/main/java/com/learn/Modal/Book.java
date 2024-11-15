package com.learn.Modal;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
public class Book {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    private String author;
}
