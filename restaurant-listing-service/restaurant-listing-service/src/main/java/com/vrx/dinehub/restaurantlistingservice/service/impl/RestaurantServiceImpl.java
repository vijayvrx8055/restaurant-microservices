package com.vrx.dinehub.restaurantlistingservice.service.impl;

import com.vrx.dinehub.restaurantlistingservice.dto.RestaurantDto;
import com.vrx.dinehub.restaurantlistingservice.entity.Restaurant;
import com.vrx.dinehub.restaurantlistingservice.mapper.RestaurantMapper;
import com.vrx.dinehub.restaurantlistingservice.repo.RestaurantRepository;
import com.vrx.dinehub.restaurantlistingservice.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private final Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    @Override
    public List<RestaurantDto> findAllHotels() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtos = restaurants.stream()
                .map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).collect(Collectors.toList());
        logger.info("Fetched all Restaurants from DB.");
        return restaurantDtos;
    }

    @Override
    public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
        restaurant.setRestaurantId(UUID.randomUUID().toString());
        Restaurant saved = restaurantRepository.save(restaurant);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(saved);
    }

    @Override
    public RestaurantDto fetchRestaurantById(String restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return restaurant.map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDto).orElse(null);
    }
}
