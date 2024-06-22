package com.vrx.dinehub.restaurantlistingservice.mapper;

import com.vrx.dinehub.restaurantlistingservice.dto.RestaurantDto;
import com.vrx.dinehub.restaurantlistingservice.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
