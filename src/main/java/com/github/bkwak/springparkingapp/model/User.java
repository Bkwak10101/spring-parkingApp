package com.github.bkwak.springparkingapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    // TODO: Fix user_reservation doesn't exist bug
//    @OneToMany()
//    private List<Reservation> reservation;
//
//    @OneToMany()
//    private List<Vehicle> vehicle;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
