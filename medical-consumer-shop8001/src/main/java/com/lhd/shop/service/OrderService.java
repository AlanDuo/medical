package com.lhd.shop.service;

import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author alan
 * @date 2021/4/3
 */
@FeignClient(value = "medical-provider-shop",contextId = "orderBack"/*,fallback = OrderFallbackService.class*/)
public interface OrderService {
    @PostMapping("/order/add_wait_to_pay")
    public Object addToWaitToPay(@RequestParam("userId") Long userId, @RequestParam("goodsId") Long goodsId, @RequestParam("amount") Integer amount);
    @GetMapping("/order/wait_to_pay")
    public Object getWaitToPayList(@RequestParam("userId")Long userId);
    @PostMapping("/order/add")
    public Object addOrder(@RequestBody OrderAddDTO orderAddDTO);
    @PostMapping("/order/pay")
    public Object payOrder(@RequestParam("orderNum") Long orderNum);
    @DeleteMapping("/order/cancel")
    public Object cancelOrder(@RequestParam("orderNum") Long orderNum);
    @PutMapping("/order/update")
    public Object updateOrder(@RequestBody OrderUpdateDTO orderUpdateDTO);
}
