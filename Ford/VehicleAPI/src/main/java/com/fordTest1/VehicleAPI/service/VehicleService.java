package com.fordTest1.VehicleAPI.service;

import com.fordTest1.VehicleAPI.model.Vehicle;
import com.fordTest1.VehicleAPI.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VehicleService {

     @Autowired
      private VehicleRepository vehicleRepository;

      public Vehicle addVehicle(Vehicle vehicle){
          return vehicleRepository.save(vehicle);
      }


    public List<Vehicle> getAllByAvailability(Boolean isAvailability) {

          List<Vehicle> all = vehicleRepository.findAll();
          if(isAvailability==null){
              return all;
           }
          else if(isAvailability){
              return all.stream().filter(Vehicle::getIsAvailable).collect(Collectors.toList());
          }
          else{
              return all.stream().filter(v->!v.getIsAvailable()).collect(Collectors.toList());
          }


    }
}
