package com.lhd.manager.service;

import com.lhd.manager.dto.GoodsAddDTO;
import com.lhd.manager.entity.Goods;
import com.lhd.manager.vo.GoodsInfoVO;
import com.lhd.manager.vo.GoodsListVO;

import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/19
 */
public interface GoodsService {
    Map<String,Object> getGoodsList(String goodsName, String goodsDesc, String goodsType, String goodsPurpose, String goodsSource, Byte status);
    boolean addGoods(GoodsAddDTO goodsAddDTO);
    GoodsInfoVO getGoodsInfo(Long goodsId);
    boolean publishGoods(Long goodsId,String price);
    boolean changeGoodsStatus(Long goodsId,Byte status);
}
