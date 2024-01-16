package com.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="my_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    private String password;
    private String role;
    private boolean isActive;
    private String imageUrl;

    @Column(length=500)
    private String about;

    @OneToMany(mappedBy="user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Contact> contacts;


}





