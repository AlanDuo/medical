package com.lhd.shop.service;

import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author alan
 * @date 2021/4/3
 */
@FeignClient(value = "medical-provider-shop",contextId = "orderBack",fallback = OrderFallbackService.class)
public interface OrderService {
    @PostMapping("/shop/order/add")
    public Object addOrder(@RequestBody OrderAddDTO orderAddDTO);
    @PostMapping("/shop/order/pay")
    public Object payOrder(@RequestParam("orderNum") Long orderNum);
    @DeleteMapping("/shop/order/cancel")
    public Object cancelOrder(@RequestParam("orderNum") Long orderNum);
    @PutMapping("/shop/order/update")
    public Object updateOrder(@RequestBody OrderUpdateDTO orderUpdateDTO);
}
