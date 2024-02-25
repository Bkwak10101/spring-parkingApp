package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Spot;
import com.github.bkwak.springparkingapp.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/spot")
@RequiredArgsConstructor
public class SpotController {

    private final SpotRepository spotRepository;

    @CrossOrigin
    @GetMapping("/all")
    public @ResponseBody List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/available")
    public @ResponseBody List<Spot> getAllAvailableSpots() {
        return spotRepository.findByAvailabilityTrue();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Spot> getSpotById(@PathVariable Long id) {
        return spotRepository.findById(id);
    }

    @CrossOrigin
    @GetMapping("/{parkingId}/{spotNum}")
    public Spot getSpotByParkingIdAndSpotNumber(@PathVariable Long parkingId, @PathVariable String spotNum) {
        return spotRepository.findSpotByParking_idAndSpotNumber(parkingId, spotNum);
    }
}
