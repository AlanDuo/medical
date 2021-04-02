package com.lhd.shop.service;

import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;

/**
 * @author alan
 * @date 2021/4/1
 */
public interface OrderService {
    boolean addOrder(OrderAddDTO orderAddDTO);
    boolean payOrder(Long orderNum);
    boolean cancelOrder(Long orderNum);
    boolean updateOrder(OrderUpdateDTO orderUpdateDTO);
}
