package com.github.bkwak.springparkingapp.service;

import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.repository.UserRepository;
import com.github.bkwak.springparkingapp.session.SessionObject;
import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Resource
    SessionObject sessionObj;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void login(String email, String passwd) {
        Optional<User> userFromDB = Optional.ofNullable(userRepository.findByEmail(email));
        if (userFromDB.isPresent() &&
                userFromDB.get().getPassword().equals(DigestUtils.md5Hex(passwd))) {
            this.sessionObj.setLoggedUser(userFromDB.get());
        }
    }

    public void logout() {
        this.sessionObj.setLoggedUser(null);
    }

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