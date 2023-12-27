package com.github.bkwak.springparkingapp.repository;

import com.github.bkwak.springparkingapp.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
