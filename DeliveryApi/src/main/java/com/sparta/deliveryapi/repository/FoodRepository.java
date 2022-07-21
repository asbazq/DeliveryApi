package com.sparta.deliveryapi.repository;

import com.sparta.deliveryapi.model.Food;

import com.sparta.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurantId(Long restaurantId);
    Optional<Food> findByRestaurantIdAndName(Long restaurantId, String menuName);
}
