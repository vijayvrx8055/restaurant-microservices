package com.vrx.dinehub.restaurantlistingservice.controller;

import com.vrx.dinehub.restaurantlistingservice.dto.RestaurantDto;
import com.vrx.dinehub.restaurantlistingservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> findAllHotels() {
        List<RestaurantDto> restaurants = restaurantService.findAllHotels();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto response = restaurantService.addRestaurantInDB(restaurantDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDto> fetchRestaurantById(@PathVariable String restaurantId) {
        RestaurantDto restaurantDto = restaurantService.fetchRestaurantById(restaurantId);
        if (restaurantDto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }
}
