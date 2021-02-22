package com.lhd.shop.service.impl;

import com.lhd.shop.dao.GoodsMapper;
import com.lhd.shop.entities.Goods;
import com.lhd.shop.service.ShopCartService;
import com.lhd.shop.vo.ShopCartVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author alan
 * @date 2020/2/22
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private GoodsMapper goodsMapper;

    public static final String SHOP_CART="shopCart";
    public static final String SHOP_ID="shopId";
    private static final Logger LOGGER= LoggerFactory.getLogger(ShopCartServiceImpl.class);

    @Override
    public List<ShopCartVO> getShopCartList(Long userId) {
        Map<Object,Object> entries=redisTemplate.opsForHash().entries(SHOP_CART+userId);
        List<ShopCartVO> shopCartVOList=new ArrayList<>();
        for(Map.Entry<Object,Object> map:entries.entrySet()){
            ShopCartVO shopCartVO=(ShopCartVO) map.getValue();
            shopCartVOList.add(shopCartVO);
        }
        return shopCartVOList;
    }

    @Override
    public boolean addToShopCart(Long userId, Long goodsId,Integer amount) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        ShopCartVO shopCartVO=new ShopCartVO();
        BeanUtils.copyProperties(goods,shopCartVO);
        shopCartVO.setUserId(userId);
        shopCartVO.setAmount(amount);
        try {
            redisTemplate.opsForHash().put(SHOP_CART + userId, SHOP_ID + goodsId, shopCartVO);
            return true;
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delShopCart(Long userId, Long goodsId) {
        try{
            redisTemplate.opsForHash().delete(SHOP_CART+userId,SHOP_ID+goodsId);
            return true;
        }catch(Exception e){
            LOGGER.info(e.getMessage());
            return false;
        }
    }
}
