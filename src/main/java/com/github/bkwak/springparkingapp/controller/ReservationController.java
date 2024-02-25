package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Reservation;
import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.repository.ReservationRepository;
import com.github.bkwak.springparkingapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = new Reservation();
        newReservation.setStartDate(reservation.getStartDate());
        newReservation.setEndDate(reservation.getEndDate());
        User user = userRepository.findByEmail("janush@gmail.com");
        newReservation.setUser_id(user);
        newReservation.setSpots(reservation.getSpots());
        newReservation.setVehicle_id(reservation.getVehicle_id());
        log.info(newReservation.toString());
        return reservationRepository.save(newReservation);
    }
}
