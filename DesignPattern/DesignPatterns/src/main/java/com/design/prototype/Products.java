package com.design.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Products {
    private String ProductsName;
    private Double price;

    public Products(String ProductsName, Double price) {
        this.ProductsName = ProductsName;
        this.price = price;
    }

    // Copy constructor
    public Products(Products other) {
        this.ProductsName = other.ProductsName;
        this.price = other.price;
    }

    // Getter and setter methods

    @Override
    public String toString() {
        return "Products{" +
                "ProductsName='" + ProductsName + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Products original = new Products("Original Products", 10.5);

        // Creating a copy using the copy constructor
        Products copy = new Products(original);

        // Modifying the copy
        copy.setProductsName("Cloned Products");
        copy.setPrice(20.0);


        System.out.println("Original Products: " + original);
        System.out.println("Cloned Products: " + copy);

    }
}

