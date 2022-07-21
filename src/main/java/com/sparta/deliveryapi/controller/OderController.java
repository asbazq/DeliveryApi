package com.sparta.deliveryapi.controller;

import com.sparta.deliveryapi.dto.OrderRequestDto;
import com.sparta.deliveryapi.dto.OrderResponseDto;
import com.sparta.deliveryapi.model.Order;
import com.sparta.deliveryapi.repository.OrderRepository;
import com.sparta.deliveryapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class OderController {

    //OrderService를 불러와 객체를 생성하여 OrderService에 연결
    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderResponseDto createOder(@RequestBody OrderRequestDto requestDto) {
        //OrderService에 함수를 만들어줌
        return orderService.createOrder(requestDto);
    }

    @GetMapping("/orders")
    public List<Order> getOrder() {
        //OrderService에 함수를 만들어줌
        return orderService.getOrder();
    }
}
