package com.fordTest1.TDDTesting1.repository;

import com.fordTest1.TDDTesting1.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void initSetup(){
        customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setAge(25);
        customer.setName("John Smith");
        customer.setCity("New York");

        // Save the customer to the database
        customerRepository.save(customer);
    }


    @Test
    public void addCustomer_returnsCustomer(){
        // Arrange
        Customer savedCustomer = customerRepository.findById(customer.getId()).orElse(null);

        // Assert
        assertNotNull(savedCustomer, "Customer should be saved and retrieved");
        Assertions.assertThat(savedCustomer.getId()).isNotNull();
        assertEquals("New York", savedCustomer.getCity());
        assertEquals(customer.getName(), savedCustomer.getName());
        assertEquals(customer.getAge(), savedCustomer.getAge());
    }

    @Test
    public void getById(){
        // Arrange
        UUID customerId = customer.getId();

        // Act
        Customer retrievedCustomer = customerRepository.findById(customerId).orElse(null);

        // Assert
        assertNotNull(retrievedCustomer, "Customer should be found by ID");
        Assertions.assertThat(retrievedCustomer.getId()).isEqualTo(customerId);
        Assertions.assertThat(retrievedCustomer.getCity()).isEqualTo(customer.getCity());
        Assertions.assertThat(retrievedCustomer.getName()).isEqualTo(customer.getName());
        Assertions.assertThat(retrievedCustomer.getAge()).isEqualTo(customer.getAge());
    }
}
