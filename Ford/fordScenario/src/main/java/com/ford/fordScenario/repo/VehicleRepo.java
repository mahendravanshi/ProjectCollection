package com.ford.fordScenario.repo;

import com.ford.fordScenario.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepo  extends JpaRepository<Vehicle, UUID> {
    List<Vehicle> findByIsAvailableFalse();

    Optional<Vehicle> findByUUID(UUID uuid);


}
