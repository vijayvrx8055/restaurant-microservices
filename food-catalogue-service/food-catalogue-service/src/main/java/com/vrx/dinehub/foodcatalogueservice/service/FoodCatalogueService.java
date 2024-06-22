package com.vrx.dinehub.foodcatalogueservice.service;

import com.vrx.dinehub.foodcatalogueservice.dto.FoodCataloguePage;
import com.vrx.dinehub.foodcatalogueservice.dto.FoodItemDto;
import com.vrx.dinehub.foodcatalogueservice.dto.Restaurant;
import com.vrx.dinehub.foodcatalogueservice.entity.FoodItem;

import java.util.List;

public interface FoodCatalogueService {
    FoodItemDto addFoodItem(FoodItemDto foodItemDto);

    FoodCataloguePage fetchRestaurantAndFoodItemById(String restaurantId);

    List<FoodCataloguePage>  fetchAllRestaurantsAndFoodItems();
}
