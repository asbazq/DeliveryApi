package com.sparta.deliveryapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderResponseDto {
    private String name;
    private int quantity;
    private int price;

    public FoodOrderResponseDto(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
