package com.github.bkwak.springparkingapp.repository;

import com.github.bkwak.springparkingapp.model.Parking;
import com.github.bkwak.springparkingapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    Parking findByName(String name);
}
