package com.sparta.deliveryapi.model;

import com.sparta.deliveryapi.dto.OrderDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column (nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private List<Food> foods;

    public Order(String restaurantName, int deliveryFee, int totalPrice, List<Food> foods) {
        this.restaurantName = restaurantName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
        this.foods = foods;
    }

    public Order(OrderDto requestDto) {
        this.restaurantName = requestDto.getRestaurantName();
        this.deliveryFee = requestDto.getDeliveryFee();
        this.totalPrice = requestDto.getTotalPrice();
        this.foods = requestDto.getFoods();

    }
}
