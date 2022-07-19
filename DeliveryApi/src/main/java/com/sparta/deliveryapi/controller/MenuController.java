package com.sparta.deliveryapi.controller;

import com.sparta.deliveryapi.dto.MenuDto;
import com.sparta.deliveryapi.model.Menus;
import com.sparta.deliveryapi.repository.MenuRepository;
import com.sparta.deliveryapi.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
@RequiredArgsConstructor // final 필드 생성자 생성
public class MenuController {
    //MenuService를 불러와 객체를 생성하여 MenuService에 연결
    private final MenuService menuService;
    private final MenuRepository menuRepository;
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public Menus createMenu(@PathVariable Long restaurantId, @RequestBody List<MenuDto> requestDto) {
        menuService.createMenu(restaurantId, requestDto);
        return null;
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Menus> getMenu(@PathVariable Long restaurantId) {
        return menuService.getMenu(restaurantId);
    }
}
