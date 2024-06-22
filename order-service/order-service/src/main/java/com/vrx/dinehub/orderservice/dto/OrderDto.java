package com.vrx.dinehub.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private String orderId;
    private List<FoodItemDto> foodItemDtoList;
    private RestaurantDto restaurantDto;
    private UserDto userDto;
}
