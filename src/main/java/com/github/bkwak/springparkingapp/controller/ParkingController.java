package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Parking;
import com.github.bkwak.springparkingapp.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/parking")
@RequiredArgsConstructor
public class ParkingController {
    private final ParkingRepository parkingRepository;

    @CrossOrigin
    @GetMapping("/all")
    public @ResponseBody List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }
}