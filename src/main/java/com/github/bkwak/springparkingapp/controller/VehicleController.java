package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.model.Vehicle;
import com.github.bkwak.springparkingapp.repository.UserRepository;
import com.github.bkwak.springparkingapp.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/all")
    public @ResponseBody List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

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

    @CrossOrigin
    @RequestMapping(path = "/id/{id}", method = RequestMethod.GET)
    private Optional<Vehicle> getById(@PathVariable final Long id){
        return vehicleRepository.findById(id);
    }

    @CrossOrigin
    @RequestMapping(path = "/num/{registrationNum}", method = RequestMethod.GET)
    private Vehicle getByRegistrationNum(@PathVariable final String registrationNum){
        log.info(vehicleRepository.findByRegistrationNum(registrationNum).toString());
        return vehicleRepository.findByRegistrationNum(registrationNum);
    }

    //TODO: Refactor with Optional<Object>
}
