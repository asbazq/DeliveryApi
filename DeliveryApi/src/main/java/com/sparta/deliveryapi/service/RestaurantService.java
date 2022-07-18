package com.sparta.deliveryapi.service;

import com.sparta.deliveryapi.dto.RestaurantRequestDto;
import com.sparta.deliveryapi.model.Restaurant;
import com.sparta.deliveryapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private static RestaurantRepository restaurantRepository;
    public static Restaurant createRestaurant (RestaurantRequestDto requestDto, int minOderPrice, int deliveryFree) {
        int oderAbleValue = requestDto.getMinOderPirce();
        int deliveryAbleValue = requestDto.getDeliveryFree();
        if ()
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Restaurant restaurant = new Restaurant(requestDto);
        restaurantRepository.save(restaurant);
        return restaurant;
        }
}
