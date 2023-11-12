package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.Reservation;
import com.github.bkwak.springparkingapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @CrossOrigin
    @PostMapping("/createReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = new Reservation();
        newReservation.setStartDate(reservation.getStartDate());
        newReservation.setEndDate(reservation.getEndDate());

        return reservationRepository.save(newReservation);
    }
}
