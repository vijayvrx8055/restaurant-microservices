package com.vrx.dinehub.hotellistingservice.mapper;

import com.vrx.dinehub.hotellistingservice.dto.RestaurantDto;
import com.vrx.dinehub.hotellistingservice.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
