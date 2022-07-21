package com.sparta.deliveryapi.controller;

import com.sparta.deliveryapi.dto.FoodDto;
import com.sparta.deliveryapi.model.Food;
import com.sparta.deliveryapi.model.FoodOrder;
import com.sparta.deliveryapi.repository.FoodRepository;
import com.sparta.deliveryapi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
@RequiredArgsConstructor // final 필드 생성자 생성
public class FoodController {
    //MenuService를 불러와 객체를 생성하여 MenuService에 연결
    private final FoodService foodService;
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createMenu(@PathVariable Long restaurantId, @RequestBody List<FoodDto> requestDto) {
        foodService.createMenu(restaurantId, requestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getMenu(@PathVariable Long restaurantId) {
        return foodService.getMenu(restaurantId);
    }
}
