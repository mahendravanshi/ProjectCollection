package com.ford.fordScenario.service;

import com.ford.fordScenario.exception.VehicleRegisterException;
import com.ford.fordScenario.model.Vehicle;
import com.ford.fordScenario.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {

        @Autowired
        private VehicleRepo vehicleRepo;

        public List<Vehicle> findNotAvailableVehicles(){
            List<Vehicle> vehicles = vehicleRepo.findByIsAvailableFalse();
            return vehicles != null ? vehicles : new ArrayList<>();
        }


    public Vehicle registerVehicle(Vehicle v) {
            if(v==null){
                throw new VehicleRegisterException("No vehicle found to register");
            }

            return vehicleRepo.save(v);
    }

    public Vehicle findByUUId(UUID any) {
            return  vehicleRepo.findByUUID(any).orElseThrow(()->new RuntimeException("No vehicle found with UIID "+any));
    }
}
