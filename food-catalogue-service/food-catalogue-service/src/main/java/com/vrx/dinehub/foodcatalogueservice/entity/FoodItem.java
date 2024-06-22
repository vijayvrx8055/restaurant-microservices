package com.vrx.dinehub.foodcatalogueservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodItem {
    @Id
    private String itemId;
    private String itemName;
    private boolean veg;
    private double price;
    private String restaurantId;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}
