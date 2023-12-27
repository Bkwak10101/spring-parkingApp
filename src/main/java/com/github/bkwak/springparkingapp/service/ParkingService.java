package com.github.bkwak.springparkingapp.service;


import com.github.bkwak.springparkingapp.model.Parking;
import com.github.bkwak.springparkingapp.repository.ParkingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ParkingService {

    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }
}
