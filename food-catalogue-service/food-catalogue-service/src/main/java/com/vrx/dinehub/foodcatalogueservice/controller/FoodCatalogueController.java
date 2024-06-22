package com.vrx.dinehub.foodcatalogueservice.controller;

import com.vrx.dinehub.foodcatalogueservice.dto.FoodCataloguePage;
import com.vrx.dinehub.foodcatalogueservice.dto.FoodItemDto;
import com.vrx.dinehub.foodcatalogueservice.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    private FoodCatalogueService foodCatalogueService;

    @PostMapping
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto) {
        FoodItemDto response = foodCatalogueService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantAndFoodItemById(@PathVariable String restaurantId) {
        FoodCataloguePage response = foodCatalogueService.fetchRestaurantAndFoodItemById(restaurantId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FoodCataloguePage>> fetchAllRestaurantsAndFoodItems() {
        List<FoodCataloguePage>  response = foodCatalogueService.fetchAllRestaurantsAndFoodItems();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
