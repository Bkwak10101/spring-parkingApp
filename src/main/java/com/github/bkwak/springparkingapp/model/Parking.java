package com.github.bkwak.springparkingapp.model;

import jakarta.persistence.*;

@Table(name = "parking")
@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spot_number")
    private String spotNumber;

}
