package com.lhd.shop.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhd.shop.dao.GoodsMapper;
import com.lhd.shop.entities.Goods;
import com.lhd.shop.entities.GoodsExample;
import com.lhd.shop.service.GoodsService;
import com.lhd.shop.vo.GoodsListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/2/18
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Map<String,Object> indexGoodsList(String searchName, Long userId) {
        GoodsExample goodsExample=new GoodsExample();
        //GoodsExample.Criteria goodsCriteria=goodsExample.createCriteria();
        if(null!=searchName && !"".equals(searchName.trim())){
            goodsExample.or().andGoodsNameLike("%"+searchName+"%");
            goodsExample.or().andGoodsTypeLike("%"+searchName+"%");
        }
        List<Goods> goodsList=goodsMapper.selectByExample(goodsExample);
        List<GoodsListVO> goodsListVOList=new ArrayList<>();
        for(Goods goods:goodsList){
            GoodsListVO goodsListVO=new GoodsListVO();
            BeanUtils.copyProperties(goods,goodsListVO);
            goodsListVOList.add(goodsListVO);
        }
        Map<String,Object> map=new HashMap<>(2);
        PageInfo pageInfo=new PageInfo<>(goodsList);
        map.put("pageInfo",pageInfo);
        map.put("list",goodsListVOList);
        return map;
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
