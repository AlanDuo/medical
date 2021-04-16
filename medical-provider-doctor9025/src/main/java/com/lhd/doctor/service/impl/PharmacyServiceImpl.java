package com.lhd.doctor.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhd.doctor.dao.DoctorAgreeMapper;
import com.lhd.doctor.dao.GoodsMapper;
import com.lhd.doctor.entity.DoctorAgree;
import com.lhd.doctor.entity.DoctorAgreeExample;
import com.lhd.doctor.entity.Goods;
import com.lhd.doctor.entity.GoodsExample;
import com.lhd.doctor.service.PharmacyService;
import com.lhd.doctor.vo.GoodsInfoVO;
import com.lhd.doctor.vo.GoodsListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/4/16
 */
@Service
public class PharmacyServiceImpl implements PharmacyService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private DoctorAgreeMapper agreeMapper;

    @Override
    public Map<String, Object> pharmacyList(String searchName) {
        GoodsExample goodsExample=new GoodsExample();
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

    @Override
    public GoodsInfoVO getPharmacyDetail(Long goodsId,Long doctorId) {
        Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
        GoodsInfoVO goodsInfoVO=new GoodsInfoVO();
        BeanUtils.copyProperties(goods,goodsInfoVO);

        DoctorAgreeExample agreeExample=new DoctorAgreeExample();
        DoctorAgreeExample.Criteria criteria=agreeExample.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        criteria.andDcotorIdEqualTo(doctorId);
        List<DoctorAgree> doctorAgreeList=agreeMapper.selectByExample(agreeExample);
        byte agree=0;
        if(doctorAgreeList.size()!=0){
            agree=1;
        }
        goodsInfoVO.setIsAgree(agree);
        return goodsInfoVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean agreeGoods(Long goodsId, Long doctorId,Byte status) {
        int num;
        if(status==1) {
            DoctorAgree doctorAgree = new DoctorAgree();
            doctorAgree.setDcotorId(doctorId);
            doctorAgree.setGoodsId(goodsId);
            agreeMapper.insertSelective(doctorAgree);
            Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
            //权重加10
            goods.setWeight(goods.getWeight()+10);
            num=goodsMapper.updateByPrimaryKeySelective(goods);
        }else{
            DoctorAgree doctorAgree=agreeMapper.selectByGoodsIdAndDoctorId(goodsId, doctorId);
            agreeMapper.deleteByPrimaryKey(doctorAgree.getAgreeId());
            Goods goods=goodsMapper.selectByPrimaryKey(goodsId);
            //权重减10
            goods.setWeight(goods.getWeight()-10);
            num=goodsMapper.updateByPrimaryKeySelective(goods);
        }
        return num>0;
    }
}
