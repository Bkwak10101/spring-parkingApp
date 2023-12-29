package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Spot;
import com.github.bkwak.springparkingapp.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/{id}")
    public ResponseEntity<Spot> getSpotById(@PathVariable Long id) {
        Optional<Spot> spot = spotRepository.findById(id);

        return spot.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
