package com.lhd.shop.controller;

import com.lhd.shop.handler.LoginUserHolder;
import com.lhd.shop.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author alan
 * @date 2021/4/3
 */
@RestController
@RequestMapping("/shop_cart")
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private LoginUserHolder loginUserHolder;

    @GetMapping("/shopCartList")
    public Object shopCartList(){
        Long userId=loginUserHolder.getCurrentUser().getId();
        return shopCartService.shopCartList(userId);
    }
    @PostMapping("/addToShopCart")
    public Object addToShopCart(Long goodsId, Integer amount){
        Long userId=loginUserHolder.getCurrentUser().getId();
        return shopCartService.addToShopCart(userId,goodsId,amount);
    }
    @DeleteMapping("/delShopCart")
    public Object delShopCart(Long goodsId){
        Long userId=loginUserHolder.getCurrentUser().getId();
        return shopCartService.delShopCart(userId,goodsId);
    }

}
