package com.lhd.shop.service;

import com.lhd.shop.common.ResponseData;
import org.springframework.stereotype.Component;

/**
 * @author alan
 * @date 2021/2/20
 */
@Component
public class ShopFallbackService implements ShopService {
    @Override
    public ResponseData goodsInfo(Long goodsId) {
        return new ResponseData(500,"服务出错，系统降级");
    }

    @Override
    public ResponseData shopIndex(String searchName, Long userId, Integer page, Integer limit) {
        return new ResponseData(500,"服务出错，系统降级");
    }
}
