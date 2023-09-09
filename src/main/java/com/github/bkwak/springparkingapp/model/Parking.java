package com.github.bkwak.springparkingapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parking_id;

    @OneToMany(mappedBy = "parking_id")
    private List<Spot> spots;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}
