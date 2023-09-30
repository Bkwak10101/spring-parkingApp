package com.github.bkwak.springparkingapp;

import com.github.bkwak.springparkingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/signup")
    public User signUp(@RequestBody User userData) {
        User newUser = new User();
        newUser.setName(userData.getName());
        newUser.setSurname(userData.getSurname());
        newUser.setPassword(userData.getPassword());
        newUser.setPhone(userData.getPhone());
        newUser.setEmail(userData.getEmail());
        return userRepository.save(newUser);
    }
}
