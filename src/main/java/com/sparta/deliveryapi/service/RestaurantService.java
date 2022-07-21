package com.sparta.deliveryapi.service;

import com.sparta.deliveryapi.dto.RestaurantRequestDto;
import com.sparta.deliveryapi.model.Restaurant;
import com.sparta.deliveryapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    //RestaurantRepository 불러와 객체를 생성하여 RestaurantRepository 연결
    private final RestaurantRepository restaurantRepository;


    // 음식점 등록
    @SneakyThrows // 명시적인 예외 처리를 생략
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언
    public Restaurant createRestaurant(RestaurantRequestDto requestDto) {
        int oderAble = requestDto.getMinOrderPrice();
        int deliveryAble = requestDto.getDeliveryFee();
        if (oderAble < 1000 || oderAble > 100000) throw new IllegalAccessException("최소주문가격 확인");
        if (oderAble % 100 != 0 ) throw  new IllegalAccessException("최소주문가격단위 확인");
        if (deliveryAble > 10000 || deliveryAble < 0) throw new  IllegalAccessException("기본 배달비 확인");
        if (deliveryAble % 500 != 0) throw new IllegalAccessException("기본 배달비단위 확인");
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Restaurant restaurant = new Restaurant(requestDto);
        //RestaurantRepository 함수를 만들어줌
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언
    public List<Restaurant> getRestaurant () {
        //RestaurantRepository 함수를 만들어줌
        return restaurantRepository.findAll();
    }
}



