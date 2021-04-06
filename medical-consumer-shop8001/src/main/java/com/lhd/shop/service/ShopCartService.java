package com.lhd.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author alan
 * @date 2021/4/3
 */
@FeignClient(value = "medical-provider-shop",contextId = "shopCartBack",fallback = ShopCartFallbackService.class)
public interface ShopCartService {
    @GetMapping("/shopCart/shopCartList")
    public Object shopCartList(@RequestParam("userId") Long userId);
    @PostMapping("/shopCart/addToShopCart")
    public Object addToShopCart(@RequestParam("userId") Long userId, @RequestParam("goodsId") Long goodsId, @RequestParam("amount") Integer amount);
    @DeleteMapping("/shopCart/delShopCart")
    public Object delShopCart(@RequestParam("userId") Long userId, @RequestParam("goodsId") Long goodsId);

}
