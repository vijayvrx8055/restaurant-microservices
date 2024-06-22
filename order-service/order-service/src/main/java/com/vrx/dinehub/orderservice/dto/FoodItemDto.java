package com.vrx.dinehub.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodItemDto {
    private String itemId;
    private String itemName;
    private boolean veg;
    private double price;
    private String restaurantId;
    private Integer quantity;
}
