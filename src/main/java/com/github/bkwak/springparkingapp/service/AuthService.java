package com.github.bkwak.springparkingapp.service;


import com.github.bkwak.springparkingapp.UserRepository;
import com.github.bkwak.springparkingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }

        return false;
    }
}