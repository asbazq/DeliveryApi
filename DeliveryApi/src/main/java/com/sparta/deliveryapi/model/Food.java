package com.sparta.deliveryapi.model;

import com.sparta.deliveryapi.dto.FoodDto;
import com.sparta.deliveryapi.dto.FoodOrderRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long restaurantId;
    @Column(nullable = false)
    private int price;

    public Food(String name, Long restaurantId, int price) {
        this.name = name;
        this.restaurantId = restaurantId;
        this.price = price;
    }
    public Food(FoodDto requestDto) {
        this.restaurantId = requestDto.getRestaurantId();
        this.price = requestDto.getPrice();
        this.name = requestDto.getName();
    }
}
