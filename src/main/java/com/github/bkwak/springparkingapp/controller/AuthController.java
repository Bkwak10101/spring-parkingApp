package com.github.bkwak.springparkingapp.controller;

import com.github.bkwak.springparkingapp.model.User;
import com.github.bkwak.springparkingapp.service.AuthService;
import com.github.bkwak.springparkingapp.session.SessionObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Resource
    SessionObject sessionObject;

    @CrossOrigin
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("isLogged",
                sessionObject.isLogged());

        log.info("USER: " + user);
        this.authService.login(user.getEmail(), user.getPassword());

        if (this.sessionObject.isLogged()) {
            model.addAttribute("logged", true);
            return "redirect:/main";
        } else {
            model.addAttribute("logged", false);
            return "login";
        }
    }

//    @CrossOrigin
//    @RequestMapping(path = "/logout", method = RequestMethod.GET)
//    public String logout() {
//        this.authService.logout();
//        return "redirect:/main";
//    }
}