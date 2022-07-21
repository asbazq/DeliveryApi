package com.sparta.deliveryapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderRequestDto {
    private Long id;
    private int quantity;
}
