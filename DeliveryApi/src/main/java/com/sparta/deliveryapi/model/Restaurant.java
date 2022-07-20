package com.sparta.deliveryapi.model;

import com.sparta.deliveryapi.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter // set 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant(String restaurantName, int minOrderPrice, int deliveryFee) {
        this.restaurantName = restaurantName;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }

    public Restaurant(RestaurantRequestDto requestDto) {
        this.restaurantName = requestDto.getName();
        this.deliveryFee = requestDto.getDeliveryFee();
        this.minOrderPrice = requestDto.getMinOrderPrice();
    }
}
