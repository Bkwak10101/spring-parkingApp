package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Parking;
import com.github.bkwak.springparkingapp.service.ParkingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/parking")
@RequiredArgsConstructor
@Slf4j
public class ParkingController {
    private final ParkingService parkingService;

    @CrossOrigin
    @GetMapping("/all")
    public @ResponseBody List<Parking> getAllParking() {

        return parkingService.getAllParking();
    }
}
