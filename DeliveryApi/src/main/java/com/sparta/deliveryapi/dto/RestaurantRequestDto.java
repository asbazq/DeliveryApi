package com.sparta.deliveryapi.dto;

import lombok.Getter;

@Getter
public class RestaurantRequestDto {
    private String name;
    private int minOderPirce;
    private int deliveryFree;
}
