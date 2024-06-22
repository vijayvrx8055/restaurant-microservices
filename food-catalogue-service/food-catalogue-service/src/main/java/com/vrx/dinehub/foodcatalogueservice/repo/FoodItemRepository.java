package com.vrx.dinehub.foodcatalogueservice.repo;

import com.vrx.dinehub.foodcatalogueservice.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, String> {

    List<FoodItem> findByRestaurantId(String restaurantId);
}
