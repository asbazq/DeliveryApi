package com.sparta.deliveryapi.dto;

import com.sparta.deliveryapi.model.Food;
import com.sparta.deliveryapi.model.FoodOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class    OrderResponseDto {
    private String restaurantName;
    private List<FoodOrder> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderResponseDto(String restaurantName, List<FoodOrder> foods, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
