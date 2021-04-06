package com.lhd.shop.service;

import com.lhd.shop.common.ResponseData;
import org.springframework.stereotype.Component;

/**
 * @author alan
 * @date 2021/4/3
 */
@Component
public class ShopCartFallbackService implements ShopCartService{
    @Override
    public ResponseData shopCartList(Long userId) {
        return new ResponseData(500,"服务出错，系统降级");
    }

    @Override
    public ResponseData addToShopCart(Long userId, Long goodsId, Integer amount) {
        return new ResponseData(500,"服务出错，系统降级");
    }

    @Override
    public ResponseData delShopCart(Long userId, Long goodsId) {
        return new ResponseData(500,"服务出错，系统降级");
    }
}
