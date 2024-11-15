package com.ford.fordScenario.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ford.fordScenario.model.Vehicle;
import com.ford.fordScenario.service.VehicleService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@WebMvcTest(VehicleController.class)
@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {


       @Autowired
     private MockMvc mockMvc;

       @Autowired
       private ObjectMapper objectMapper;

       @Autowired
       private VehicleController vehicleController;

       @MockBean
      private VehicleService vehicleService;

       private List<Vehicle> vehicles;

       @BeforeEach
       void setUp(){

           vehicles = new ArrayList<>();
           Vehicle v1 = Mockito.mock(Vehicle.class);
           Vehicle v2 = Mockito.mock(Vehicle .class);
           Vehicle v3 = Mockito.mock(Vehicle.class);

           when(v1.getId()).thenReturn(UUID.randomUUID());
           when(v1.getName()).thenReturn("ABC");
           when(v1.getIsAvailable()).thenReturn(false);

           when(v2.getId()).thenReturn(UUID.randomUUID());
           when(v2.getName()).thenReturn("BCD");
           when(v2.getIsAvailable()).thenReturn(true);

           when(v3.getId()).thenReturn(UUID.randomUUID());
           when(v3.getName()).thenReturn("CDE");
           when(v3.getIsAvailable()).thenReturn(false);

           vehicles.add(v1);
           vehicles.add(v2);
           vehicles.add(v3);

       }

       @Test
       void getAllVehicles_returnNotAvailableVehicles() throws Exception {


           when(vehicleService.findNotAvailableVehicles()).thenReturn(vehicles);

           var perform = mockMvc.perform(MockMvcRequestBuilders.get("/vehicles/getAllNotAvailableVehicles"));


           perform.andExpect(MockMvcResultMatchers.status().isOk())
                   .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)))
                   .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",Matchers.is("ABC")))
                   .andExpect(MockMvcResultMatchers.jsonPath("$[1].name",Matchers.is("BCD")))
                   .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty())
                   .andExpect(MockMvcResultMatchers.jsonPath("$[0].isAvailable",Matchers.is(false)));

       }



}
