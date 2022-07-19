package com.sparta.deliveryapi.service;

import com.sparta.deliveryapi.dto.MenuDto;
import com.sparta.deliveryapi.model.Menus;
import com.sparta.deliveryapi.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor // final 필드 생성자 생성
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public void createMenu(Long restaurantId, List<MenuDto> requestDto) {
        for (MenuDto menuDto : requestDto) {
            String menuName = menuDto.getName();
            int menuPrice = menuDto.getPrice();

            Optional<Menus> menuList = menuRepository.findByRestaurantIdAndName(restaurantId, menuName);
            if (menuList.isPresent()) throw new IllegalArgumentException("중복 확인");
            if (menuPrice < 100 || menuPrice > 1000000) throw new IllegalArgumentException("가격 확인");
            if (menuPrice % 100 != 0) throw new IllegalArgumentException("가격 단위 확인");

            Menus menu = new Menus(menuName, menuPrice, restaurantId);
            menuRepository.save(menu);
        }
    }

    public List<Menus> getMenu(@PathVariable Long restaurantId) {
        List<Menus> menu = menuRepository.findByRestaurantId(restaurantId);
        return menu;
    }
}
