package com.vrx.dinehub.hotellistingservice.service;

import com.vrx.dinehub.hotellistingservice.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> findAllHotels();

    RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto);

    RestaurantDto fetchRestaurantById(String restaurantId);
}
