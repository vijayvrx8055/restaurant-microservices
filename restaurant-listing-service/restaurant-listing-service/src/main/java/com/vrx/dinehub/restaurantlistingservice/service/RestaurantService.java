package com.vrx.dinehub.restaurantlistingservice.service;

import com.vrx.dinehub.restaurantlistingservice.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> findAllHotels();

    RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto);

    RestaurantDto fetchRestaurantById(String restaurantId);
}
