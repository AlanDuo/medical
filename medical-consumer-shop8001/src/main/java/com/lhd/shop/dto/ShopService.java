package com.lhd.shop.dto;

import com.lhd.shop.service.ShopFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "medical-provider-shop",fallback = ShopFallbackService.class)
public interface ShopService {
    @GetMapping("/shop/goodsInfo/{goodsId}")
    public Object goodsInfo(@PathVariable("goodsId") Long goodsId);
    @GetMapping("/shop/index")
    public Object shopIndex(@RequestParam("searchName") String searchName, @RequestParam("userId") Long userId,
                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "limit", defaultValue = "20") Integer limit);
}
