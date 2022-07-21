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
        // 리스트 형태이기 때문에 for each문으로 객체리스트를 불러옴
        for (FoodDto foodDto : requestDto) {
            String foodName = foodDto.getName();
            int foodPrice = foodDto.getPrice();

            // 같은 음식점 내 음식의 중복 확인하기위해 레포지토리에서 아이디값이랑 네임을 불러와서 중복 확인
            Optional<Food> foodList = foodRepository.findByRestaurantIdAndName(restaurantId, foodName);
            // isPresent()로 중복확인
            if (foodList.isPresent()) throw new IllegalArgumentException("중복 확인");
            if (foodPrice < 100 || foodPrice > 1000000) throw new IllegalArgumentException("가격 확인");
            if (foodPrice % 100 != 0) throw new IllegalArgumentException("가격 단위 확인");

            // 요청받은 DTO 로 DB에 저장할 객체 만들기
            Food food = new Food(foodName, restaurantId, foodPrice);
            foodRepository.save(food);
        }
    }

    @Transactional
    public List<Food> getMenu(@PathVariable Long restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId);
    }
}
