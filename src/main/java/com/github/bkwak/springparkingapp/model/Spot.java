package com.github.bkwak.springparkingapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spotId;

    @ManyToOne
    @JoinColumn(name = "parking_id", nullable = false)
    private Parking parking_id;

    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation_id;

    @Column(name = "spot_number")
    private String spotNumber;

    @Column(name = "availability")
    private Boolean availability;

}
