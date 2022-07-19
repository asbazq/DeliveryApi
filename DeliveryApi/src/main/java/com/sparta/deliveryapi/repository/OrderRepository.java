package com.sparta.deliveryapi.repository;

import com.sparta.deliveryapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
