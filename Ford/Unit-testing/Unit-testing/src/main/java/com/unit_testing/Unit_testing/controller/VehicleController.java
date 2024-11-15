package com.unit_testing.Unit_testing.controller;

import com.unit_testing.Unit_testing.entity.Vehicle;
import com.unit_testing.Unit_testing.repository.VehicleRepository;
import com.unit_testing.Unit_testing.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicle")
    public List<Vehicle> getNotAvailableVehicles() {
        return vehicleService.getNotAvailableVehicles();
    }
}
