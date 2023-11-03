package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/signup")
    public User signUp(@RequestBody User userData) {
        User newUser = new User();
        newUser.setName(userData.getName());
        newUser.setSurname(userData.getSurname());
        String encodedPassword = passwordEncoder.encode(userData.getPassword());
        newUser.setPassword(encodedPassword);
        newUser.setPhone(userData.getPhone());
        newUser.setEmail(userData.getEmail());
        return userRepository.save(newUser);
    }
}
