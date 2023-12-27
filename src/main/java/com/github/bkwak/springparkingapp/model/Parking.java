package com.github.bkwak.springparkingapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "parking")
@Data
@NoArgsConstructor
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
