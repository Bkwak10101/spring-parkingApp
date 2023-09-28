package com.github.bkwak.springparkingapp;

import com.github.bkwak.springparkingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public User signUp(@RequestBody User userData) {
        User newUser = new User();
        newUser.setName(userData.getName());
        newUser.setSurname(userData.getSurname());
        newUser.setPhone(userData.getPhone());
        newUser.setEmail(userData.getEmail());
        return userRepository.save(newUser);
    }
}
