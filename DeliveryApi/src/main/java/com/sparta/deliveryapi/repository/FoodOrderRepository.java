package com.sparta.deliveryapi.repository;

import com.sparta.deliveryapi.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
