package com.oddId.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "oddNumberGenerator")
    @GenericGenerator(name = "oddNumberGenerator", strategy = "com.oddId.entity.OddNumberGenerator")
    private Integer id;


    @Column(unique=false)
    private String name;


}
