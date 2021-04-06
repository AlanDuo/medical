package com.lhd.shop.controller;

import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import com.lhd.shop.handler.LoginUserHolder;
import com.lhd.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author alan
 * @date 2021/4/3
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private LoginUserHolder loginUserHolder;

    @PostMapping("/add")
    public Object addOrder(@RequestBody OrderAddDTO orderAddDTO){
        return orderService.addOrder(orderAddDTO);
    }
    @PostMapping("/pay")
    public Object payOrder(Long orderNum){
        return orderService.payOrder(orderNum);
    }
    @DeleteMapping("/cancel")
    public Object cancelOrder(Long orderNum){
        return orderService.cancelOrder(orderNum);
    }
    @PutMapping("/update")
    public Object updateOrder(@RequestBody OrderUpdateDTO orderUpdateDTO){
        return orderService.updateOrder(orderUpdateDTO);
    }
}
