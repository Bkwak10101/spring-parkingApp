package com.github.bkwak.springparkingapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;

    @Column(name = "registration_num")
    private String registrationNum;

    @Column(name = "vehicle_type")
    private String vehicleType;
}
