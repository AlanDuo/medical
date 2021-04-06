package com.lhd.shop.service;

import com.lhd.shop.common.ResponseData;
import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import org.springframework.stereotype.Component;

/**
 * @author alan
 * @date 2021/4/3
 */
@Component
public class OrderFallbackService implements OrderService{
    @Override
    public ResponseData addOrder(OrderAddDTO orderAddDTO) {
        return new ResponseData(500,"服务出错，系统降级");
    }

    @Override
    public ResponseData payOrder(Long orderNum) {
        return new ResponseData(500,"服务出错，系统降级");
    }

    @Override
    public ResponseData cancelOrder(Long orderNum) {
        return new ResponseData(500,"服务出错，系统降级");
    }

    @Override
    public ResponseData updateOrder(OrderUpdateDTO orderUpdateDTO) {
        return null;
    }
}
