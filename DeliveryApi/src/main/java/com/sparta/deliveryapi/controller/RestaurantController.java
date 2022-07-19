package com.sparta.deliveryapi.controller;

import com.sparta.deliveryapi.dto.RestaurantRequestDto;
import com.sparta.deliveryapi.model.Restaurant;
import com.sparta.deliveryapi.repository.RestaurantRepository;
import com.sparta.deliveryapi.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
@RequiredArgsConstructor // final 필드 생성자 생성
public class RestaurantController {
    //RestaurantService를 불러와 객체를 생성하여 RestaurantService에 연결
    private final RestaurantService restaurantService;
    //RestaurantRepository를 불러와 객체를 생성하여 RestaurantRepository에 연결
    private final RestaurantRepository restaurantRepository;

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant (@RequestBody RestaurantRequestDto requestDto) {
        //RestaurantService에 함수를 만들어줌
        Restaurant restaurant = restaurantService.createRestaurant(requestDto);
        return restaurant;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant () {
        return restaurantRepository.findAll();
    }
}
