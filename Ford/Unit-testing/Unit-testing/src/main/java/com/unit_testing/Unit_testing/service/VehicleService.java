package com.unit_testing.Unit_testing.service;

import com.unit_testing.Unit_testing.entity.Vehicle;
import com.unit_testing.Unit_testing.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getNotAvailableVehicles() {
        return vehicleRepository.findByIsAvailableFalse();
    }
}
