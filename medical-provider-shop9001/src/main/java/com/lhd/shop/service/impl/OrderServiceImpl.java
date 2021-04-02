package com.lhd.shop.service.impl;

import com.lhd.shop.dao.ShopOrderMapper;
import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import com.lhd.shop.entities.ShopOrder;
import com.lhd.shop.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author alan
 * @date 2021/4/1
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ShopOrderMapper orderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrder(OrderAddDTO orderAddDTO) {
        ShopOrder shopOrder=new ShopOrder();
        BeanUtils.copyProperties(orderAddDTO,shopOrder);
        shopOrder.setCreateTime(new Date());
        return orderMapper.insertSelective(shopOrder)>0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean payOrder(Long orderNum) {
        ShopOrder order=orderMapper.selectByOrderNumber(orderNum);
        order.setPayTime(new Date());
        return orderMapper.updateByPrimaryKeySelective(order)>0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean cancelOrder(Long orderNum) {
        return orderMapper.deleteByOrderNumber(orderNum)>0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateOrder(OrderUpdateDTO orderUpdateDTO) {
        ShopOrder order=orderMapper.selectByOrderNumber(orderUpdateDTO.getOrderNum());
        if(null!=orderUpdateDTO.getUsername() && !"".equals(orderUpdateDTO.getUsername())){
            order.setUsername(orderUpdateDTO.getUsername());
        }
        if(null!=orderUpdateDTO.getPhone() && !"".equals(orderUpdateDTO.getPhone())){
            order.setPhone(orderUpdateDTO.getPhone());
        }
        if(null!=orderUpdateDTO.getAddress()&& !"".equals(orderUpdateDTO.getAddress())){
            order.setAddress(orderUpdateDTO.getAddress());
        }

        return orderMapper.updateByPrimaryKeySelective(order)>0;
    }
}
