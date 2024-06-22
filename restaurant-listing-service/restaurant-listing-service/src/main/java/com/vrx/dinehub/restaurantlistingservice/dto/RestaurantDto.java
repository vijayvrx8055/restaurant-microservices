package com.vrx.dinehub.restaurantlistingservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RestaurantDto {
    private String restaurantId;
    private String name;
    private String address;
    private String city;
    private String description;
}
