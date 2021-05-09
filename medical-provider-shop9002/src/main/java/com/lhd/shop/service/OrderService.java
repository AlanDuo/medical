package com.lhd.shop.service;

import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import com.lhd.shop.vo.WaitToPayListVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/4/1
 */
public interface OrderService {
    boolean addWaitToPay(Long userId,Long goodsId,Integer amount);
    List<WaitToPayListVO> getWaitToPayList(Long userId);
    boolean addOrder(OrderAddDTO orderAddDTO);
    boolean payOrder(Long orderNum);
    boolean cancelOrder(Long orderNum);
    boolean updateOrder(OrderUpdateDTO orderUpdateDTO);
}
