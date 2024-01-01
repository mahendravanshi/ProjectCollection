package com.security.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
public class Order {

    private Integer orderId;
    private Double price;
    private Integer userId;



}
