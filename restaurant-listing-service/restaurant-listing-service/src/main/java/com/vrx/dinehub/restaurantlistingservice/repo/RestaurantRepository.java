package com.vrx.dinehub.restaurantlistingservice.repo;

import com.vrx.dinehub.restaurantlistingservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
}
