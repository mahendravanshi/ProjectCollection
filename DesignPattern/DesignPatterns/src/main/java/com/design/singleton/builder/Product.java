package com.design.singleton.builder;


public class Product {
    private String productName;
    private Double price;
    // ... other parts of the product

    // Private constructor to force the use of the static method for instantiation
    private Product() {
    }

    // Static method to create an instance of the builder
    public static Product builder() {
        return new Product();
    }

    // Methods for building different parts of the product with method chaining
    public Product productName(String productName) {
        this.productName = productName;
        return this;
    }

    public Product price(Double price) {
        this.price = price;
        return this;
    }

    // ... other methods for different parts with method chaining

    // Method to build the final product
    public Product build() {
        return this;  // Simply return the current instance, as it's already configured
    }

    // Example usage
    public static void main(String[] args) {
        Product product = Product.builder()
                .productName("Part 1")
                // ... other parts
                .build();



    }
}
