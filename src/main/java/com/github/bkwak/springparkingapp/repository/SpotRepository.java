package com.github.bkwak.springparkingapp.repository;

import com.github.bkwak.springparkingapp.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findByAvailabilityTrue();

    @Query("SELECT s FROM Spot s WHERE s.parking_id.parking_id = :parkingId AND s.spotNumber = :spotNumber")
    Spot findSpotByParking_idAndSpotNumber(@Param("parkingId") Long parkingId, @Param("spotNumber") String spotNumber);

}
