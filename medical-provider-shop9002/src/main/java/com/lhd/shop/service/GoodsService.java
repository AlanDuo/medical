package com.lhd.shop.service;

import com.lhd.shop.entities.Goods;
import com.lhd.shop.vo.GoodsListVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/2/18
 */
public interface GoodsService {
    /**
     * 首页商品推荐
     *
     * @param searchName
     * @param userId
     * @return
     */
    List<GoodsListVO> indexGoodsList(String searchName,Long userId);

    /**
     * 单个商品详情
     *
     * @param goodsId
     * @return
     */
    Goods goodsInfo(Long goodsId);
}
