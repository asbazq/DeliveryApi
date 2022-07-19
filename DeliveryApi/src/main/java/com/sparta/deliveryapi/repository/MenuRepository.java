package com.sparta.deliveryapi.repository;

import com.sparta.deliveryapi.model.Menus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menus, Long> {
    List<Menus> findByRestaurantId(Long restaurantId);
    Optional<Menus> findByRestaurantIdAndName(Long restaurantId, String menuName);
}
