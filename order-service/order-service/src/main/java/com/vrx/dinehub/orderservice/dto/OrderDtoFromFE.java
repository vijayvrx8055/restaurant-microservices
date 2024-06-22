package com.vrx.dinehub.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFromFE {
        private List<FoodItemDto> foodItemDtoList;
        private String userId;
        private RestaurantDto restaurantDto;

}
