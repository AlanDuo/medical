package com.lhd.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "medical-provider-shop")
public interface ShopService {
    @GetMapping("/shop/goodsInfo/{goodsId}")
    public Object goodsInfo(@PathVariable("goodsId") Long goodsId);
}
