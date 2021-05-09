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
    @Autowired
    public ShopCartController(ShopCartService shopCartService){
        this.shopCartService=shopCartService;
    }

    @GetMapping("/shopCartList")
    public ResponseData shopCartList(Long userId){
        List<ShopCartVO> shopCartVOList=shopCartService.getShopCartList(userId);
        return ResponseData.ok().putDataValue(shopCartVOList);
    }
    @PostMapping("/addToShopCart")
    public ResponseData addToShopCart(Long userId,Long goodsId,Integer amount){
        shopCartService.addToShopCart(userId,goodsId,amount);
        return ResponseData.ok();
    }
    @DeleteMapping("/delShopCart")
    public ResponseData delShopCart(Long userId,Long goodsId){
        shopCartService.delShopCart(userId,goodsId);
        return ResponseData.ok();
    }
}
