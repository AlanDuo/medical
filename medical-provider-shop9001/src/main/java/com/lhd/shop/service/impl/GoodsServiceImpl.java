package com.lhd.shop.service.impl;

import com.lhd.shop.dao.GoodsMapper;
import com.lhd.shop.entities.Goods;
import com.lhd.shop.service.GoodsService;
import com.lhd.shop.vo.GoodsListVO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/18
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsListVO> indexGoodsList(String searchName,Long userId) {

        return null;
    }

    @Cacheable(value = "goodsInfo",key = "#goodsId")
    @Override
    public Goods goodsInfo(Long goodsId) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        if(null!=goods){
            return goods;
        }
        return null;
    }
}
