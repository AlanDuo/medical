package com.lhd.shop.service;

import com.lhd.shop.common.ResponseData;
import org.springframework.stereotype.Component;

/**
 * @author alan
 * @date 2021/2/20
 */
@Component
public class ShopFallbckService implements ShopService {
    @Override
    public ResponseData goodsInfo(Long goodsId) {
        return new ResponseData(500,"服务降级");
    }
}
