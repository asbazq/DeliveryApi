package com.sparta.deliveryapi.service;

import com.sparta.deliveryapi.dto.FoodOrderResponseDto;
import com.sparta.deliveryapi.dto.OrderRequestDto;
import com.sparta.deliveryapi.dto.OrderResponseDto;
import com.sparta.deliveryapi.model.Food;
import com.sparta.deliveryapi.model.FoodOrder;
import com.sparta.deliveryapi.dto.FoodOrderRequestDto;
import com.sparta.deliveryapi.model.Order;
import com.sparta.deliveryapi.model.Restaurant;
import com.sparta.deliveryapi.repository.FoodOrderRepository;
import com.sparta.deliveryapi.repository.FoodRepository;
import com.sparta.deliveryapi.repository.OrderRepository;
import com.sparta.deliveryapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor // final 필드 생성자 생성
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;

    // 주문
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        // OrderRequestDto 에 있는 restaurantId를 통해 restaurantName, deliveryFee 값 불러오기
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("식당 확인"));
        int totalPrice = 0;
        int deliveryFee = restaurant.getDeliveryFee();
        String restaurantName = restaurant.getRestaurantName();


        // OrdersDto에 들어갈 FoodOrderDto 리스트와 Orders에 들어갈 FoodOrder 리스트가 필요하기 때문에 각각 생성
        // 리턴할 타입의 리스트 생성
        List<FoodOrderResponseDto> foodOrderResponseDtoList = new ArrayList<>();
        // db에 저장할 리스트 생성
        List<FoodOrder> foodOrderList = new ArrayList<>();

        for (FoodOrderRequestDto foodOrderDto : requestDto.getFoods()) {
            Food food = foodRepository.findByIdAndRestaurant(foodOrderDto.getId(),restaurant).orElseThrow(
                    ()->new IllegalArgumentException("음식 확인"));

            String name = food.getName();
            int quantity = foodOrderDto.getQuantity();
            int price = food.getPrice() * quantity;

            if (quantity < 1 || quantity > 100) throw new IllegalArgumentException("수량 확인");

            totalPrice += price;

            // FoodOrder 리스트에 값 넣어 테이블에 저장
            FoodOrder foodOrder = new FoodOrder(name,price,quantity);
            foodOrderList.add(foodOrder);
            foodOrderRepository.save(foodOrder);

            // FoodOrderResponseDto 리스트에 값 넣어 리스폰스바디에 넣기(리턴이라서 저장 X)
            FoodOrderResponseDto foodOrderResponseDto = new FoodOrderResponseDto(name,price,quantity);
            foodOrderResponseDtoList.add(foodOrderResponseDto);
        }
        if (restaurant.getMinOrderPrice() > totalPrice) throw new IllegalArgumentException("최소주문가격 미달");
        totalPrice += deliveryFee;

        // 리턴해줄 OrdersDto 생성
        OrderResponseDto orderResponseDto = new OrderResponseDto(restaurantName, foodOrderList, deliveryFee, totalPrice);
        // Orders 테이블에 넣어줄 Orders 객체 생성 후 레포지토리에 저장
        Order order = new Order(restaurantName, deliveryFee, totalPrice, foodOrderList);
        orderRepository.save(order);
        return orderResponseDto;
    }
    @Transactional
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
}
