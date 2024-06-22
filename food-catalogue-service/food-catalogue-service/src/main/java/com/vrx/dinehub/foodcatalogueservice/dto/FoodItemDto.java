package com.vrx.dinehub.foodcatalogueservice.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FoodItemDto {
    private String itemId;
    private String itemName;
    private boolean veg;
    private double price;
    private String restaurantId;
    private Integer quantity;
}
