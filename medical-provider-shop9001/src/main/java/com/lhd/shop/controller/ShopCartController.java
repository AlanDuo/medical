package com.lhd.shop.controller;

import com.lhd.shop.common.ResponseData;
import com.lhd.shop.handler.LoginUserHolder;
import com.lhd.shop.service.ShopCartService;
import com.lhd.shop.vo.ShopCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2020/2/22
 */
@RestController
@RequestMapping("/shopCart")
public class ShopCartController {
    private ShopCartService shopCartService;
    private LoginUserHolder loginUserHolder;
    @Autowired
    public ShopCartController(ShopCartService shopCartService,LoginUserHolder loginUserHolder){
        this.shopCartService=shopCartService;
        this.loginUserHolder=loginUserHolder;
    }

    @GetMapping("/shopCartList")
    public ResponseData shopCartList(){
        List<ShopCartVO> shopCartVOList=shopCartService.getShopCartList(1L);
        return ResponseData.ok().putDataValue(shopCartVOList);
    }
    @PostMapping("/addToShopCart")
    public ResponseData addToShopCart(Long goodsId,Integer amount){
        long userId=loginUserHolder.getCurrentUser().getId();
        shopCartService.addToShopCart(userId,goodsId,amount);
        return ResponseData.ok();
    }
    @DeleteMapping("/delShopCart")
    public ResponseData delShopCart(Long goodsId){
        long userId=loginUserHolder.getCurrentUser().getId();
        shopCartService.delShopCart(userId,goodsId);
        return ResponseData.ok();
    }
}
