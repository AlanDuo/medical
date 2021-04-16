package com.lhd.doctor.service;

import com.lhd.doctor.vo.GoodsInfoVO;

import java.util.Map;

/**
 * @author alan
 * @date 2021/4/16
 */
public interface PharmacyService {
    Map<String,Object> pharmacyList(String searchName);
    GoodsInfoVO getPharmacyDetail(Long goodsId,Long doctorId);
    boolean agreeGoods(Long goodsId,Long doctorId,Byte status);
}
