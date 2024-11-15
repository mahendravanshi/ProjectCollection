package com.unit_testing.Unit_testing.repository;

import com.unit_testing.Unit_testing.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    public List<Vehicle> findByIsAvailableFalse();
}
