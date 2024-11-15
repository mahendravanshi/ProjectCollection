package com.ford.fordScenario.controller;

import com.ford.fordScenario.model.Vehicle;
import com.ford.fordScenario.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @PostMapping()
    public ResponseEntity<Vehicle> registerVehicle(@RequestBody Vehicle v){
        return new ResponseEntity<>(vehicleService.registerVehicle(v),HttpStatus.CREATED);
    }



    @GetMapping("/getAllNotAvailableVehicles")
    public ResponseEntity<List<Vehicle>> getAllNotAvaliableVheicles(){

        return new ResponseEntity<>( vehicleService.findNotAvailableVehicles(), HttpStatus.OK);

    }


}
