package com.vrx.dinehub.foodcatalogueservice.service.impl;

import com.vrx.dinehub.foodcatalogueservice.dto.FoodCataloguePage;
import com.vrx.dinehub.foodcatalogueservice.dto.FoodItemDto;
import com.vrx.dinehub.foodcatalogueservice.dto.Restaurant;
import com.vrx.dinehub.foodcatalogueservice.entity.FoodItem;
import com.vrx.dinehub.foodcatalogueservice.mapper.FoodItemMapper;
import com.vrx.dinehub.foodcatalogueservice.repo.FoodItemRepository;
import com.vrx.dinehub.foodcatalogueservice.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FoodCatalogueServiceImpl implements FoodCatalogueService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItem = FoodItemMapper.MAPPER.mapFoodItemDtoToFoodItem(foodItemDto);
        foodItem.setItemId(UUID.randomUUID().toString());
        FoodItem foodItemSaved = foodItemRepository.save(foodItem);
        return FoodItemMapper.MAPPER.mapFoodItemToFoodItemDto(foodItemSaved);
    }

    @Override
    public FoodCataloguePage fetchRestaurantAndFoodItemById(String restaurantId) {
        List<FoodItem> foodItems = fetchFoodItemsList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItems, restaurant);
    }

    @Override
    public List<FoodCataloguePage> fetchAllRestaurantsAndFoodItems() {
        List<FoodItem> foodItems = foodItemRepository.findAll();
        Stream<FoodCataloguePage> foodCataloguePageStream = foodItems.stream().map(foodItem -> fetchRestaurantAndFoodItemById(foodItem.getRestaurantId()));
        return foodCataloguePageStream.toList();
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItems, Restaurant restaurant) {
        return FoodCataloguePage.builder()
                .foodItemsList(foodItems)
                .restaurant(restaurant)
                .build();
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(String restaurantId) {
        String url = "http://RESTAURANT-SERVICE/restaurants/" + restaurantId;
        return restTemplate.getForObject(url, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemsList(String restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }


}
