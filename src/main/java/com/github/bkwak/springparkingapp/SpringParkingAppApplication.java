package com.github.bkwak.springparkingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringParkingAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringParkingAppApplication.class, args);
    }
}
