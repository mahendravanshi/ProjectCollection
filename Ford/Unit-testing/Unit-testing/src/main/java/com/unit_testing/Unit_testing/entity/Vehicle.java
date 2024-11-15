package com.unit_testing.Unit_testing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Boolean isAvailable;
}


