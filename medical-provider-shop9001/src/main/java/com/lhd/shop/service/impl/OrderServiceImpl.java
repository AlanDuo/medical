package com.lhd.shop.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lhd.shop.dao.GoodsMapper;
import com.lhd.shop.dao.ShopOrderMapper;
import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import com.lhd.shop.entities.Goods;
import com.lhd.shop.entities.ShopOrder;
import com.lhd.shop.service.OrderService;
import com.lhd.shop.vo.ShopCartVO;
import com.lhd.shop.vo.WaitToPayListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/4/1
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ShopOrderMapper orderMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private RedisTemplate redisTemplate;

    public static final String WAIT_TO_PAY="waitToPay";
    public static final String GOODS_ID="goodsId";
    public static final String SHOP_CART="shopCart";
    public static final String SHOP_ID="shopId";
    private static final Logger LOGGER= LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public boolean addWaitToPay(Long userId, Long goodsId, Integer amount) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        WaitToPayListVO waitToPayListVO=new WaitToPayListVO();
        BeanUtils.copyProperties(goods,waitToPayListVO);
        waitToPayListVO.setUserId(userId);
        waitToPayListVO.setAmount(amount);
        long orderId=Long.parseLong(RandomUtil.randomString("123456789",6));
        waitToPayListVO.setOrderId(orderId);
        try {
            redisTemplate.opsForHash().put(WAIT_TO_PAY + userId, GOODS_ID + goodsId, waitToPayListVO);
            redisTemplate.opsForHash().delete(SHOP_CART+userId,SHOP_ID+goodsId);
            return true;
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    @Override
    public List<WaitToPayListVO> getWaitToPayList(Long userId) {
        Map<Object,Object> entries=redisTemplate.opsForHash().entries(WAIT_TO_PAY+userId);
        List<WaitToPayListVO> waitToPayList=new ArrayList<>();
        for(Map.Entry<Object,Object> map:entries.entrySet()){
            WaitToPayListVO waitToPayListVO=(WaitToPayListVO) map.getValue();
            waitToPayList.add(waitToPayListVO);
        }
        return waitToPayList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrder(OrderAddDTO orderAddDTO) {
        ShopOrder shopOrder=new ShopOrder();
        BeanUtils.copyProperties(orderAddDTO,shopOrder);
        shopOrder.setCreateTime(new Date());
        shopOrder.setPayTime(new Date());
        byte status=1;
        shopOrder.setStatus(status);
        redisTemplate.opsForHash().delete(WAIT_TO_PAY + orderAddDTO.getUserId(), GOODS_ID + orderAddDTO.getGoodsId());
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
