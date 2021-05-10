package com.lhd.user.service.impl;

import com.github.pagehelper.PageInfo;
import com.lhd.user.dao.*;
import com.lhd.user.entities.*;
import com.lhd.user.service.OrderService;
import com.lhd.user.vo.ConsultationOrderListVO;
import com.lhd.user.vo.PrescriptionVO;
import com.lhd.user.vo.ShopOrderListVO;
import com.lhd.user.vo.ShopOrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/2/24
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ShopOrderMapper shopOrderMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private ConsultationOrderMapper consultationOrderMapper;
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Resource
    private UserMapper userMapper;

    /**
     *================商城订单================
     */
    @Override
    public Map<String,Object> getShopOrderList(Long userId,Byte status) {
        ShopOrderExample orderExample=new ShopOrderExample();
        orderExample.setOrderByClause("create_time DESC");
        ShopOrderExample.Criteria orderCriteria=orderExample.createCriteria();
        orderCriteria.andUserIdEqualTo(userId);
        orderCriteria.andStatusEqualTo(status);
        List<ShopOrder> shopOrderList=shopOrderMapper.selectByExample(orderExample);
        Map<String,Object> map=new HashMap<>();
        PageInfo pageInfo=new PageInfo<>(shopOrderList);
        map.put("pageInfo",pageInfo);
        List<ShopOrderListVO> orderListVOList=new ArrayList<>();
        if(shopOrderList.size()!=0){
            for(ShopOrder shopOrder:shopOrderList){
                Goods goods=goodsMapper.selectByPrimaryKey(shopOrder.getGoodsId());
                ShopOrderListVO orderListVO=new ShopOrderListVO();
                BeanUtils.copyProperties(goods,orderListVO);
                BeanUtils.copyProperties(shopOrder,orderListVO);
                orderListVO.setPrice(goods.getWholesalePrice().multiply(new BigDecimal(shopOrder.getAmount())));
                orderListVOList.add(orderListVO);
            }
        }
        map.put("list",orderListVOList);
        return map;
    }

    @Override
    public ShopOrderVO getShopOrderDetail(Long orderId) {
        ShopOrder shopOrder=shopOrderMapper.selectByPrimaryKey(orderId);
        if(null!=shopOrder){
            ShopOrderVO shopOrderVO=new ShopOrderVO();
            Goods goods=goodsMapper.selectByPrimaryKey(shopOrder.getGoodsId());
            BeanUtils.copyProperties(shopOrder,shopOrderVO);
            BeanUtils.copyProperties(goods,shopOrderVO);
            shopOrderVO.setPrice(goods.getWholesalePrice());
            shopOrderVO.setStatus(shopOrder.getStatus());
            shopOrderVO.setPrice(goods.getWholesalePrice());
            return shopOrderVO;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateShopOrderStatus(Long orderId, Byte status) {
        ShopOrder shopOrder=shopOrderMapper.selectByPrimaryKey(orderId);
        shopOrder.setStatus(status);
        return shopOrderMapper.updateByPrimaryKeySelective(shopOrder)>0;
    }

    /**
     *================问诊订单================
     */

    @Override
    public List<ConsultationOrderListVO> getConsultationOrderList(Long userId) {
        ConsultationOrderExample orderExample=new ConsultationOrderExample();
        orderExample.setOrderByClause("order_time DESC");
        ConsultationOrderExample.Criteria orderCriteria=orderExample.createCriteria();
        orderCriteria.andPatientIdEqualTo(userId);
        List<ConsultationOrder> consultationOrderList=consultationOrderMapper.selectByExample(orderExample);
        List<ConsultationOrderListVO> orderListVOList=new ArrayList<>();
        for(ConsultationOrder order:consultationOrderList){
            ConsultationOrderListVO orderListVO=new ConsultationOrderListVO();
            BeanUtils.copyProperties(order,orderListVO);
            Doctor doctor=doctorMapper.selectByPrimaryKey(order.getDoctorId());
            BeanUtils.copyProperties(doctor,orderListVO);
            User user=userMapper.selectByPrimaryKey(order.getPatientId());
            BeanUtils.copyProperties(user,orderListVO);
            Prescription prescription=prescriptionMapper.selectByPrimaryKey(order.getOrderId());
            BeanUtils.copyProperties(prescription,orderListVO);
            orderListVOList.add(orderListVO);
        }
        return orderListVOList;
    }

    @Override
    public PrescriptionVO getPrescriptionOfOrder(Long orderId) {
        PrescriptionExample prescriptionExample=new PrescriptionExample();
        PrescriptionExample.Criteria prescriptionCriteria=prescriptionExample.createCriteria();
        prescriptionCriteria.andOrderIdEqualTo(orderId);
        List<Prescription> prescriptions=prescriptionMapper.selectByExample(prescriptionExample);
        if(prescriptions.size()==0){
            return null;
        }
        PrescriptionVO prescriptionVO=new PrescriptionVO();
        BeanUtils.copyProperties(prescriptions.get(0),prescriptionVO);

        return prescriptionVO;
    }
}
