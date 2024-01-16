package com.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String secondName;
    private String work;
    private String email;
    private String phone;
    private String image;

    @Column(length=50000)
    private String description;


     @ManyToOne
     @JoinColumn(name="user_id")
     private User user;


}
