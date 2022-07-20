package com.sparta.deliveryapi.repository;

import com.sparta.deliveryapi.model.Food;
import com.sparta.deliveryapi.model.FoodOrder;
import com.sparta.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurantId(Long restaurantId);
    Optional<Food> findByRestaurantIdAndName(Long restaurantId, String menuName);
    Optional<Food> findByIdAndRestaurant(Long Id, Restaurant restaurant);
}
