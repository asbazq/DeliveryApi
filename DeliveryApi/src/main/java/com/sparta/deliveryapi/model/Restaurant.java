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
    private String name;

    @Column(nullable = false)
    private int minOderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant(String name, int minOderPrice, int deliveryFee) {
        this.name = name;
        this.minOderPrice = minOderPrice;
        this.deliveryFee = deliveryFee;
    }

    public Restaurant(RestaurantRequestDto requestDto) {
        this.name = requestDto.getName();
        this.minOderPrice = requestDto.getMinOderPirce();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}
