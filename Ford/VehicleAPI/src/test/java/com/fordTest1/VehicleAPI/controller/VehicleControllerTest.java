package com.fordTest1.VehicleAPI.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fordTest1.VehicleAPI.model.Vehicle;
import com.fordTest1.VehicleAPI.service.VehicleService;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

       @MockBean
       private VehicleService vehicleService;

       @Autowired
       private ObjectMapper objectMapper;

       private Vehicle vehicle;


       private List<Vehicle> vehicles;

       private UUID id = UUID.randomUUID();

       @BeforeEach
       void initSetup(){

             vehicles = new ArrayList<>();
             vehicle = new Vehicle(id,"BrandT",true);

           vehicles.add(vehicle);
           vehicles.add(new Vehicle(UUID.randomUUID(), "BrandA", true));
           vehicles.add(new Vehicle(UUID.randomUUID(), "BrandB", false));
           vehicles.add(new Vehicle(UUID.randomUUID(), "BrandC", true));
           vehicles.add(new Vehicle(UUID.randomUUID(), "BrandD", false));
           vehicles.add(new Vehicle(UUID.randomUUID(), "BrandE", true));

       }

       @Test
       public void addVehicle_returnsVehicle() throws Exception{


        Mockito.when(vehicleService.addVehicle(vehicle)).thenReturn(vehicle);


        var perform = mockMvc.perform(post("/vehicles")
                .content(objectMapper.writeValueAsString(vehicle))
                .contentType(MediaType.APPLICATION_JSON)
        );

        perform
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.isAvailable", Matchers.is(true)));

    }

}
