package com.sparta.deliveryapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto {
    private Long RestaurantId;
    private String name;
    private int price;
}
