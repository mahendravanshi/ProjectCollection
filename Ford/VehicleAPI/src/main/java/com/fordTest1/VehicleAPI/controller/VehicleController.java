package com.fordTest1.VehicleAPI.controller;



import com.fordTest1.VehicleAPI.model.Vehicle;
import com.fordTest1.VehicleAPI.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicleByAvailability(@RequestParam(required=false,defaultValue="true") Boolean isAvailable){
          return new ResponseEntity<>(vehicleService.getAllByAvailability(isAvailable),HttpStatus.FOUND);
    }







}
