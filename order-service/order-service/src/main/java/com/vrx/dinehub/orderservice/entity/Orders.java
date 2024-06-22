package com.vrx.dinehub.orderservice.entity;

import com.vrx.dinehub.orderservice.dto.FoodItemDto;
import com.vrx.dinehub.orderservice.dto.RestaurantDto;
import com.vrx.dinehub.orderservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("orders")
public class Orders {
    private String orderId;
    private List<FoodItemDto> foodItemDtoList;
    private RestaurantDto restaurantDto;
    private UserDto userDto;
}
