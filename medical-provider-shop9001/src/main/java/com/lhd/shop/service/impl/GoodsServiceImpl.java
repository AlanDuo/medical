package com.lhd.shop.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhd.shop.dao.GoodsEvaluateMapper;
import com.lhd.shop.dao.GoodsMapper;
import com.lhd.shop.dao.UserMapper;
import com.lhd.shop.entities.*;
import com.lhd.shop.service.GoodsService;
import com.lhd.shop.vo.GoodsInfoVO;
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
    @Resource
    private GoodsEvaluateMapper evaluateMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Map<String,Object> indexGoodsList(String searchName, Long userId) {
        GoodsExample goodsExample=new GoodsExample();
        goodsExample.setOrderByClause("weight DESC");
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
    public GoodsInfoVO goodsInfo(Long goodsId) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        GoodsInfoVO goodsInfoVO=new GoodsInfoVO();
        BeanUtils.copyProperties(goods,goodsInfoVO);
        GoodsEvaluateExample evaluateExample=new GoodsEvaluateExample();
        evaluateExample.setOrderByClause("evaluate_time desc");
        GoodsEvaluateExample.Criteria criteria=evaluateExample.createCriteria();
        criteria.andGodosIdEqualTo(goodsId);
        List<GoodsEvaluate> evaluateList=evaluateMapper.selectByExample(evaluateExample);
        if(evaluateList.size()!=0){
            GoodsEvaluate goodsEvaluate=evaluateList.get(0);
            User user=userMapper.selectByPrimaryKey(goodsEvaluate.getUserId());
            goodsInfoVO.setEvaUserId(goodsEvaluate.getUserId());
            goodsInfoVO.setEvaUsername(user.getUsername());
            goodsInfoVO.setEvaUserImg(user.getUserImg());
            goodsInfoVO.setEvaContent(goodsEvaluate.getContent());
        }

        return goodsInfoVO;
    }
}
