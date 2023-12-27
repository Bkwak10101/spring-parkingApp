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
    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = new Reservation();
        newReservation.setStartDate(reservation.getStartDate());
        newReservation.setEndDate(reservation.getEndDate());

        newReservation.setSpot(reservation.getSpot());
        newReservation.setVehicle_id(reservation.getVehicle_id());

        return reservationRepository.save(newReservation);
    }
}
