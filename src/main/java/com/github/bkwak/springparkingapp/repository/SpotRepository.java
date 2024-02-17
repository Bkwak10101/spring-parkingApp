package com.github.bkwak.springparkingapp.repository;

import com.github.bkwak.springparkingapp.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {
    List<Spot> findByAvailabilityTrue();
//    Spot findSpotByParkingIdAndSpotNumber();

}
