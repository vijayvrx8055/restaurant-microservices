package com.vrx.dinehub.hotellistingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    private String restaurantId;
    private String name;
    private String address;
    private String city;
    private String description;
}
