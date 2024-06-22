package com.vrx.dinehub.foodcatalogueservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private String restaurantId;
    private String name;
    private String address;
    private String city;
    private String description;
}
