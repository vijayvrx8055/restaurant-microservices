package com.vrx.dinehub.foodcatalogueservice.dto;

import com.vrx.dinehub.foodcatalogueservice.entity.FoodItem;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodCataloguePage {
    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}
