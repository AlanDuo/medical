package com.lhd.manager.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhd.manager.dao.GoodsMapper;
import com.lhd.manager.dto.GoodsAddDTO;
import com.lhd.manager.entity.Goods;
import com.lhd.manager.entity.GoodsExample;
import com.lhd.manager.service.GoodsService;
import com.lhd.manager.vo.GoodsInfoVO;
import com.lhd.manager.vo.GoodsListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author alan
 * @date 2021/3/19
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Map<String,Object> getGoodsList(String goodsName, String goodsDesc, String goodsType, String goodsPurpose, String goodsSource, Byte status) {
        GoodsExample goodsExample=new GoodsExample();
        GoodsExample.Criteria goodsCriteria=goodsExample.createCriteria();
        if(null!=goodsName && !"".equals(goodsName.trim())){
            goodsCriteria.andGoodsNameLike("%"+goodsName+"%");
        }
        if(null!=goodsDesc && !"".equals(goodsDesc.trim())){
            goodsCriteria.andGoodsDescLike("%"+goodsDesc+"%");
        }
        if(null!=goodsType && !"".equals(goodsType.trim())){
            goodsCriteria.andGoodsTypeLike("%"+goodsType+"%");
        }
        if(null!=goodsPurpose && !"".equals(goodsPurpose.trim())){
            goodsCriteria.andGoodsPurposeLike("%"+goodsPurpose+"%");
        }
        if(null!=goodsSource && !"".equals(goodsSource.trim())){
            goodsCriteria.andGoodsSourceLike("%"+goodsSource+"%");
        }
        if(null!=status){
            goodsCriteria.andStatusEqualTo(status);
        }
        List<Goods> goodsList=goodsMapper.selectByExample(goodsExample);
        PageInfo pageInfo=new PageInfo<>(goodsList);

        List<GoodsListVO> goodsListVOList=new ArrayList<>();
        for(Goods goods:goodsList){
            GoodsListVO goodsListVO=new GoodsListVO();
            BeanUtils.copyProperties(goods,goodsListVO);
            goodsListVOList.add(goodsListVO);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("pageInfo",pageInfo);
        map.put("list",goodsListVOList);
        return map;
    }

    @Override
    public GoodsInfoVO getGoodsInfo(Long goodsId) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        GoodsInfoVO goodsInfoVO=new GoodsInfoVO();
        BeanUtils.copyProperties(goods,goodsInfoVO);
        return goodsInfoVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addGoods(GoodsAddDTO goodsAddDTO) {
        Goods goods=new Goods();
        BeanUtils.copyProperties(goodsAddDTO,goods);
        goods.setPurchaseTime(new Date());
        byte status=0;
        goods.setStatus(status);
        return goodsMapper.insertSelective(goods)>0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean publishGoods(Long goodsId,String price){
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        goods.setWholesalePrice(new BigDecimal(price));
        byte status=1;
        goods.setStatus(status);
        goods.setUpTime(new Date());
        return goodsMapper.updateByPrimaryKeySelective(goods)>0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean changeGoodsStatus(Long goodsId,Byte status) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        goods.setStatus(status);
        if(status==1){
            //商品上架
            goods.setUpTime(new Date());
        }else{
            //商品下架
            goods.setDownTime(new Date());
        }
        return goodsMapper.updateByPrimaryKeySelective(goods)>0;
    }

}
