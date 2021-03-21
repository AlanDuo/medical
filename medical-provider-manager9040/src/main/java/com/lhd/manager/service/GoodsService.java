package com.lhd.manager.service;

import com.lhd.manager.dto.GoodsAddDTO;
import com.lhd.manager.entity.Goods;
import com.lhd.manager.vo.GoodsInfoVO;
import com.lhd.manager.vo.GoodsListVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/3/19
 */
public interface GoodsService {
    List<GoodsListVO> getGoodsList(String goodsName, String goodsDesc, String goodsType, String goodsPurpose, String goodsSource);
    boolean addGoods(GoodsAddDTO goodsAddDTO);
    GoodsInfoVO getGoodsInfo(Long goodsId);
    boolean changeGoodsStatus(Long goodsId,Byte status);
}
