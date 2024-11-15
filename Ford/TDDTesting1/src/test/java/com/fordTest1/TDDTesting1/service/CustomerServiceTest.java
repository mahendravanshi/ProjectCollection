package com.fordTest1.TDDTesting1.service;


import com.fordTest1.TDDTesting1.exception.ResourceNotFoundException;
import com.fordTest1.TDDTesting1.model.Customer;
import com.fordTest1.TDDTesting1.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;
    private List<Customer> customerList;

    @BeforeEach
    public void initSetup() {

        customerList = new ArrayList<>();
        customer = new Customer(UUID.randomUUID(), "John Doe", 25, "New York");
        Customer customer2 = new Customer(UUID.randomUUID(), "Jane Smith", 30, "Los Angeles");
        Customer customer3 = new Customer(UUID.randomUUID(), "Emily Johnson", 35, "New York");
        Customer customer4 = new Customer(UUID.randomUUID(), "Michael Brown", 40, "Chicago");
        Customer customer5 = new Customer(UUID.randomUUID(), "Lisa White", 28, "Los Angeles");
        Customer customer6 = new Customer(UUID.randomUUID(), "James Green", 22, "Miami");
        Customer customer7 = new Customer(UUID.randomUUID(), "Sarah Davis", 30, "Chicago");
        Customer customer8 = new Customer(UUID.randomUUID(), "David Wilson", 25, "Miami");
        Customer customer9 = new Customer(UUID.randomUUID(), "Nancy Martinez", 40, "New York");
        Customer customer10 = new Customer(UUID.randomUUID(), "Robert Anderson", 35, "Miami");

        customerList.add(customer);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        customerList.add(customer6);
        customerList.add(customer7);
        customerList.add(customer8);
        customerList.add(customer9);
        customerList.add(customer10);

    }


    @Test
    public void addCustomer_returnsCustomer() {

        // Arrange
        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        //Act
        Customer actual = customerService.addCustomer(customer);

        // Assert
        Assertions.assertNotNull(actual, "The returned customer should not be null.");
        Assertions.assertEquals(customer.getAge(), actual.getAge(), "The ages should match.");
        Assertions.assertEquals(customer.getName(), actual.getName(), "The names should match.");
        Assertions.assertEquals(customer.getCity(), actual.getCity(), "The cities should match.");
        Assertions.assertEquals(customer.getId(), actual.getId(), "The IDs should match.");

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();

    }


    @Test
    public void getAllCustomers_WithCityAndAge_returnsCustomers() {
        //Arrange
        Integer listSize = customerList.size();
        Mockito.when(customerRepository.findAll()).thenReturn(customerList);


        // Act
        List<Customer> actualList = customerService.getAll(null, null);


        // Assert
        Assertions.assertEquals(actualList, customerList);
        Assertions.assertEquals(customerList.size(), actualList.size());
        Assertions.assertEquals(actualList.get(0), customerList.get(0));


        assertThat(actualList).isNotEmpty();
    }


    @Test
    public void getAllCustomersByAge_returnsAllCustomersByAge() {
        //Arrange
        Integer age = 30;
        List<Customer> filteredAge = customerList.stream().filter(c -> age.equals(c.getAge())).toList();

        Mockito.when(customerRepository.findAll()).thenReturn(filteredAge);


        //Act
        List<Customer> actualList = customerService.getAll(age, null);

        //Assert
        Assertions.assertEquals(actualList, filteredAge, "Both array should be same");
        Assertions.assertEquals(actualList.get(0), filteredAge.get(0), "Both ith index elements should be same");
        Assertions.assertNotNull(actualList, "ActualList should not be null");
        Assertions.assertEquals(actualList.get(0).getAge(), age, "Age should match with 30");
        Assertions.assertEquals(actualList.get(0).getCity(), filteredAge.get(0).getCity(), "Both city should match");
        Assertions.assertTrue(actualList.stream().allMatch(c -> c.getAge().equals(age)), "All customers should match with age");

        assertThat(actualList).isNotEmpty();
        assertThat(actualList.size()).isEqualTo(filteredAge.size());
    }


    @Test
    public void getAllCustomersByCity_returnsAllCustomersByCity() {

        //Arrange
        String city = "New York";
        List<Customer> filteredCity = customerList.stream().filter(c -> city.equals(c.getCity())).toList();

        Mockito.when(customerRepository.findAll()).thenReturn(filteredCity);


        //Act
        List<Customer> actualList = customerService.getAll(null, city);

        //Assert
        Assertions.assertEquals(actualList, filteredCity, "Both array should be same");
        Assertions.assertEquals(actualList.get(0), filteredCity.get(0), "Both ith index elements should be same");
        Assertions.assertNotNull(actualList, "ActualList should not be null");
        Assertions.assertEquals(actualList.get(0).getCity(), city, "City should match with New York");
        Assertions.assertEquals(actualList.get(0).getCity(), filteredCity.get(0).getCity(), "Both city should match");
        Assertions.assertTrue(actualList.stream().allMatch(c -> c.getCity().equals(city)), "All customers should match with city");

        assertThat(actualList).isNotEmpty();
        assertThat(actualList.size()).isEqualTo(filteredCity.size());

    }


    @Test
    public void getAll_ReturnsEmptyArray() {

        //Arrange
        Integer age = 10;
        String city = null;

        List<Customer> emptyList = new ArrayList<>();

        Mockito.when(customerRepository.findAll()).thenReturn(emptyList);

        //Act
        List<Customer> expected = customerService.getAll(age, null);


        //Assert
        Assertions.assertEquals(expected, emptyList, "The resultant list should be empty");
        Assertions.assertTrue(expected.isEmpty(), "expected should be empty when age is 10");
        assertThat(expected).isEmpty();
        assertThat(expected.size()).isEqualTo(0);

    }


    @Test
    public void deleteById_deleteSuccessfullyReturnsNothing() {

        // Arrange
        UUID customerId = UUID.randomUUID();

        Mockito.doNothing().when(customerRepository).deleteById(customerId);
        // Mocking the repository to indicate the entity exists
        Mockito.when(customerRepository.existsById(customerId)).thenReturn(true);
        //Act
        customerService.deleteById(customerId);

        //Assert
        verify(customerRepository, times(1)).deleteById(customerId);

    }


    @Test
    public void deleteById_throwsException() {

        UUID customerId = UUID.randomUUID();

        // Mocking the repository to indicate the entity does not exist
        Mockito.when(customerRepository.existsById(customerId)).thenReturn(false);


        //Act and Assert
        ResourceNotFoundException rnf = Assertions.assertThrows(ResourceNotFoundException.class, () -> customerService.deleteById(customerId), "Resource Not found");

        Assertions.assertEquals(rnf.getMessage(),"No record found to delete");
        verify(customerRepository, Mockito.never()).deleteById(customerId);

    }

    @Test
    public void getById_returnsCustomer() {

        // Arrange
        UUID customerId = customer.getId();

        Mockito.when(customerRepository.existsById(customerId)).thenReturn(true);
        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.ofNullable(customer));


        // Act
        Customer expected = customerService.getById(customerId);

        Assertions.assertEquals(customer.getCity(), expected.getCity());

        Mockito.verify(customerRepository, times(1)).findById(customerId);
    }


    @Test
    public void getById_notFoundThrowError() {

        //Arrange
        UUID customerId = UUID.randomUUID();

        Mockito.when(customerRepository.existsById(customerId)).thenReturn(false);

        //Act and Asert

        Assertions.assertThrows(ResourceNotFoundException.class, () -> customerService.getById(customerId), "No record found");

        verify(customerRepository,times(1)).existsById(customerId);
        verify(customerRepository, Mockito.never()).findById(customerId);

    }


}
