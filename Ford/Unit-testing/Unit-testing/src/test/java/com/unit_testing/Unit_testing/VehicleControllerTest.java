package com.unit_testing.Unit_testing;

import com.unit_testing.Unit_testing.controller.VehicleController;
import com.unit_testing.Unit_testing.entity.Vehicle;
import com.unit_testing.Unit_testing.repository.VehicleRepository;
import com.unit_testing.Unit_testing.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(VehicleControllerTest.class)
public class VehicleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private VehicleService vehicleService;
    @InjectMocks
    private VehicleController vehicleController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc=standaloneSetup(vehicleController).build();
    }

    @Test
    void shouldFetchAllNotAvailableVehicles() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(UUID.randomUUID());
        vehicle.setName("Vehicle 1");
        vehicle.setIsAvailable(false);

        when(vehicleService.getNotAvailableVehicles()).thenReturn(Collections.singletonList(vehicle));
//        List<Vehicle> notAvailableVehicles = vehicleController.getNotAvailableVehicles();
//        assertThat(notAvailableVehicles).isNotNull();
//        assertThat(notAvailableVehicles).isNotEmpty();
//        assertEquals(vehicle.getName(), notAvailableVehicles.get(0).getName());

        mockMvc.perform(get("/vehicle"))
                .andDo(MockMvcResultHandlers.print()) // This will print the response to help debug
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(vehicle.getId().toString()))
                .andExpect(jsonPath("$[0].name").value(vehicle.getName()))
                .andExpect(jsonPath("$[0].isAvailable").value(false));
    }
}
