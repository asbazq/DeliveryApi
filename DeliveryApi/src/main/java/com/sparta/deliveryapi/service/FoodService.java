package com.sparta.deliveryapi.service;

import com.sparta.deliveryapi.dto.FoodDto;
import com.sparta.deliveryapi.model.Food;
import com.sparta.deliveryapi.repository.FoodRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Getter
@RequiredArgsConstructor // final 필드 생성자 생성
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public void createMenu(Long restaurantId, @RequestBody List<FoodDto> requestDto) {
        for (FoodDto foodDto : requestDto) {
            String foodName = foodDto.getName();
            int foodPrice = foodDto.getPrice();

            Optional<Food> foodList = foodRepository.findByRestaurantIdAndName(restaurantId, foodName);
            if (foodList.isPresent()) throw new IllegalArgumentException("중복 확인");
            if (foodPrice < 100 || foodPrice > 1000000) throw new IllegalArgumentException("가격 확인");
            if (foodPrice % 100 != 0) throw new IllegalArgumentException("가격 단위 확인");

            Food food = new Food(foodName, restaurantId, foodPrice);
            foodRepository.save(food);
        }
    }

    public List<Food> getMenu(@PathVariable Long restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId);
    }
}
