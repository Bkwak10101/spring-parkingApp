package com.github.bkwak.springparkingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "vehicle")
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "registration_num")
    private String registrationNum;

    @Column(name = "vehicle_type")
    private String vehicleType;

    Vehicle(Long vehicle_id){
        this.vehicle_id = vehicle_id;
    }
}
