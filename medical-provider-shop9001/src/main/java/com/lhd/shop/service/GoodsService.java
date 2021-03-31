package com.lhd.shop.service;

import com.lhd.shop.vo.GoodsInfoVO;
import java.util.Map;

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
    Map<String,Object> indexGoodsList(String searchName, Long userId);

    /**
     * 单个商品详情
     *
     * @param goodsId
     * @return
     */
    GoodsInfoVO goodsInfo(Long goodsId);
}
