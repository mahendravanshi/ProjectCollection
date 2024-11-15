package com.fordTest1.VehicleAPI.repository;

import com.fordTest1.VehicleAPI.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

      List<Vehicle> findAllByIsAvailable(Boolean isAvailable);
      List<Vehicle> findAllByBrandName(String brandName);

}
