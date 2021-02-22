package com.lhd.shop.controller;

import com.lhd.shop.common.ResponseData;
import com.lhd.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/goodsInfo/{goodsId}")
    public Object goodsInfo(@PathVariable("goodsId") Long goodsId){

        return shopService.goodsInfo(goodsId);
    }
}
