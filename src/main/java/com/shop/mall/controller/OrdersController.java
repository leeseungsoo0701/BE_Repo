package com.shop.mall.controller;

import com.shop.mall.dto.OrdersRequestDto;
import com.shop.mall.dto.OrdersResponseDto;
import com.shop.mall.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrdersController {
    private final OrdersService ordersService;

    //15번 API
    @GetMapping("/orders")
    public List<OrdersResponseDto.ordersList> findAllOrders(@RequestHeader(value = "Authorization") String nickname){
        return ordersService.findAllOrders(nickname);
    }

    //16번 API
    @PostMapping("/orders")
    public String orderProduct(@RequestHeader(value = "Authorization") String nickname, @RequestBody OrdersRequestDto.orderProduct dto){
        return ordersService.orderProduct(nickname,dto);
    }

}
