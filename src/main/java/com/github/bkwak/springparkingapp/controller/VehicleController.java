package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Vehicle;
import com.github.bkwak.springparkingapp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @CrossOrigin
    @PostMapping("/createVehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setRegistrationNum(vehicle.getRegistrationNum());

        return vehicleRepository.save(newVehicle);
    }
}
