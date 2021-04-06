package com.lhd.shop.controller;

import com.lhd.shop.handler.LoginUserHolder;
import com.lhd.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private LoginUserHolder loginUserHolder;

    @GetMapping("/goodsInfo/{goodsId}")
    public Object goodsInfo(@PathVariable("goodsId") Long goodsId){
        return shopService.goodsInfo(goodsId);
    }
    @GetMapping("/index")
    public Object shopIndex(String searchName,
                            @RequestParam(value = "page",defaultValue = "1") Integer page,
                            @RequestParam(value = "limit",defaultValue = "20") Integer limit){
        //获取登录用户
        //Long userId=loginUserHolder.getCurrentUser().getId();
        return shopService.shopIndex(searchName, null, page, limit);
    }
}
