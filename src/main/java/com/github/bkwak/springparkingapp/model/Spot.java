package com.github.bkwak.springparkingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "spot")
@Data
@NoArgsConstructor
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spot_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parking_id", nullable = false)
    private Parking parking_id;

    @Column(name = "spot_number")
    private String spotNumber;

    @Column(name = "availability")
    private Boolean availability;

    public Spot(Parking parking_id, String spotNumber) {
        this.parking_id = parking_id;
        this.spotNumber = spotNumber;
    }
}
