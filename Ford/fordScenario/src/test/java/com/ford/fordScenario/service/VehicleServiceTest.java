package com.ford.fordScenario.service;

import com.ford.fordScenario.model.Vehicle;
import com.ford.fordScenario.repo.VehicleRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepo vehicleRepo;

    @InjectMocks
    private VehicleService vehicleService;

    private List<Vehicle> vehicles;

    @BeforeEach
    void setUp() {
        vehicles = new ArrayList<>();

        Vehicle v1 = new Vehicle();
        v1.setId(UUID.randomUUID());
        v1.setName("ABC");
        v1.setIsAvailable(false);

        Vehicle v2 = new Vehicle();
        v2.setId(UUID.randomUUID());
        v2.setName("BCD");
        v2.setIsAvailable(false);

        Vehicle v3 = new Vehicle();
        v3.setId(UUID.randomUUID());
        v3.setName("CDE");
        v3.setIsAvailable(false);

        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);
    }


    @Test
    void getAllUnavailableVehicles_returnsNonEmptyList() {
        Mockito.when(vehicleRepo.findByIsAvailableFalse()).thenReturn(vehicles);

        List<Vehicle> result = vehicleService.findNotAvailableVehicles();

        Assertions.assertEquals(result,vehicles);
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
    }



    @Test
    void getAllUnavailableVehicles_repositoryReturnsNull() {
        Mockito.when(vehicleRepo.findByIsAvailableFalse()).thenReturn(null);
        List<Vehicle> result = vehicleService.findNotAvailableVehicles();
        assertThat(result).isEmpty();
    }


    @Test
    public void throwsErrorWhenPostingVehicle(){

           Mockito.when(vehicleRepo.findByUUID(Mockito.any(UUID.class))).thenReturn(Optional.empty());

           Assertions.assertThrows(RuntimeException.class,()->vehicleService.findByUUId(Mockito.any(UUID.class)),"No vehicle found with UUID");
    }




}
