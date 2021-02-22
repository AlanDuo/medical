package com.lhd.shop.service;

import com.lhd.shop.vo.ShopCartVO;

import java.util.List;

/**
 * @author alan
 * @date 2020/2/22
 */
public interface ShopCartService {
    public List<ShopCartVO> getShopCartList(Long userId);
    public boolean addToShopCart(Long userId,Long goodsId,Integer amount);
    public boolean delShopCart(Long userId,Long goodsId);
}
