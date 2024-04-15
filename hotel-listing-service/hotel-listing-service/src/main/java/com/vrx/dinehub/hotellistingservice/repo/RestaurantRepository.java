package com.vrx.dinehub.hotellistingservice.repo;

import com.vrx.dinehub.hotellistingservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
}
