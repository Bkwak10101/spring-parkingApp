package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.model.Vehicle;
import com.github.bkwak.springparkingapp.repository.UserRepository;
import com.github.bkwak.springparkingapp.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/create")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVehicleType(vehicle.getVehicleType());
        newVehicle.setRegistrationNum(vehicle.getRegistrationNum());
        User user = userRepository.findByEmail("janush@gmail.com");
        newVehicle.setUser(user);
        return vehicleRepository.save(newVehicle);
    }
}
