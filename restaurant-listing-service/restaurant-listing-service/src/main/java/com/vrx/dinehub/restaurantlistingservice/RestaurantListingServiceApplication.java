package com.vrx.dinehub.restaurantlistingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vrx.dinehub.restaurantlistingservice")
public class RestaurantListingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantListingServiceApplication.class, args);
    }
}
