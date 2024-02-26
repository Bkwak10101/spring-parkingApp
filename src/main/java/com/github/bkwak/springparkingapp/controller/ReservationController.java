package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Reservation;
import com.github.bkwak.springparkingapp.model.Spot;
import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.repository.ReservationRepository;
import com.github.bkwak.springparkingapp.repository.SpotRepository;
import com.github.bkwak.springparkingapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpotRepository spotRepository;

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<?> addReservation(@RequestBody Reservation reservation) {
        User user = userRepository.findByEmail("janush@gmail.com");
        reservation.setUser_id(user);
        Reservation newReservation = reservationRepository.save(reservation);

        List<Spot> spots = newReservation.getSpots();
        if (spots != null && !spots.isEmpty()) {
            for (Spot spot : spots) {
                updateSpotAvailability(spot.getSpot_id());
            }
        }

        log.info(newReservation.toString());
        return ResponseEntity.ok(newReservation);
    }
    @PutMapping("/{spotId}")
    public ResponseEntity<?> updateSpotAvailability(@PathVariable Long spotId) {
        Spot spot = spotRepository.findById(spotId)
                .orElseThrow(() -> new RuntimeException("Parking spot with the id doesn't exist: " + spotId));
        spot.setAvailability(false);
        spotRepository.save(spot);

        return ResponseEntity.ok().build();
    }
}
