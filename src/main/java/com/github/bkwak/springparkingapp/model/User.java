package com.github.bkwak.springparkingapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @OneToMany(mappedBy = "user_id")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "vehicle_id")
    private List<Vehicle> vehicles;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}
