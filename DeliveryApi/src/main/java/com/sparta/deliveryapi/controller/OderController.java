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

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @PostMapping("/order/request")
    public OrderResponseDto createOder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    @GetMapping("/orders")
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
}
