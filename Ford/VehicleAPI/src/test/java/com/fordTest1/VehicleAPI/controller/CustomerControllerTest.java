//package com.fordTest1.VehicleAPI.controller;
//
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import com.fordTest1.VehicleAPI.model.Customer;
//import com.fordTest1.VehicleAPI.service.CustomerService;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(CustomerController.class)
//@ExtendWith(MockitoExtension.class)
//public class CustomerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    Customer customer;
//    private List<Customer> customerList;
//
//    @BeforeEach
//    public void initSetup(){
//
//        customerList = new ArrayList<>();
//        customer = new Customer(UUID.randomUUID(), "John Doe", 25, "New York");
//        Customer customer2 = new Customer(UUID.randomUUID(), "Jane Smith", 30, "Los Angeles");
//        Customer customer3 = new Customer(UUID.randomUUID(), "Emily Johnson", 35, "New York");
//        Customer customer4 = new Customer(UUID.randomUUID(), "Michael Brown", 40, "Chicago");
//        Customer customer5 = new Customer(UUID.randomUUID(), "Lisa White", 28, "Los Angeles");
//        Customer customer6 = new Customer(UUID.randomUUID(), "James Green", 22, "Miami");
//        Customer customer7 = new Customer(UUID.randomUUID(), "Sarah Davis", 30, "Chicago");
//        Customer customer8 = new Customer(UUID.randomUUID(), "David Wilson", 25, "Miami");
//        Customer customer9 = new Customer(UUID.randomUUID(), "Nancy Martinez", 40, "New York");
//        Customer customer10 = new Customer(UUID.randomUUID(), "Robert Anderson", 35, "Miami");
//
//           customerList.add(customer);
//        customerList.add(customer2);
//        customerList.add(customer3);
//        customerList.add(customer4);
//        customerList.add(customer5);
//        customerList.add(customer6);
//        customerList.add(customer7);
//        customerList.add(customer8);
//        customerList.add(customer9);
//        customerList.add(customer10);
//
//    }
//
//
//    @Test
//    public void addCustomer_returnsCustomer() throws Exception {
//
//           Mockito.when(customerService.addCustomer(Mockito.any(Customer.class))).thenReturn(customer);
//
//              var perform = mockMvc.perform(MockMvcRequestBuilders.post("/customers")
//                      .content(objectMapper.writeValueAsString(customer))
//                      .contentType(MediaType.APPLICATION_JSON)
//              );
//
//
//              perform.andExpect(status().isCreated())
//                      .andExpect(jsonPath("$.name",Matchers.is("John Doe")))
//                      .andExpect(jsonPath("$.age",Matchers.is(25)))
//                      .andExpect(jsonPath("$.city",Matchers.is("New York")))
//                      .andExpect(jsonPath("$.id").isNotEmpty())
//                      .andExpect(jsonPath("$.name").isString());
//
//
//
//    }
//
//}
//