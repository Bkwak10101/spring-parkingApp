package com.github.bkwak.springparkingapp.repository;

import com.github.bkwak.springparkingapp.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {
}
