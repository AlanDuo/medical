package com.lhd.user.service.impl;

import com.lhd.user.dao.*;
import com.lhd.user.entities.*;
import com.lhd.user.service.OrderService;
import com.lhd.user.vo.ConsultationOrderListVO;
import com.lhd.user.vo.ShopOrderListVO;
import com.lhd.user.vo.ShopOrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    public List<ShopOrderListVO> getShopOrderList(Long userId) {
        ShopOrderExample orderExample=new ShopOrderExample();
        orderExample.setOrderByClause("create_time DESC");
        ShopOrderExample.Criteria orderCriteria=orderExample.createCriteria();
        orderCriteria.andUserIdEqualTo(userId);
        List<ShopOrder> shopOrderList=shopOrderMapper.selectByExample(orderExample);
        if(shopOrderList.size()!=0){
            List<ShopOrderListVO> orderListVOList=new ArrayList<>();
            for(ShopOrder shopOrder:shopOrderList){
                Goods goods=goodsMapper.selectByPrimaryKey(shopOrder.getGoodsId());
                ShopOrderListVO orderListVO=new ShopOrderListVO();
                BeanUtils.copyProperties(goods,orderListVO);
                BeanUtils.copyProperties(shopOrder,orderListVO);
                orderListVOList.add(orderListVO);
            }
            return orderListVOList;
        }
        return null;
    }

    @Override
    public ShopOrderVO getShopOrderDetail(Long orderId) {
        ShopOrder shopOrder=shopOrderMapper.selectByPrimaryKey(orderId);
        if(null!=shopOrder){
            ShopOrderVO shopOrderVO=new ShopOrderVO();
            Goods goods=goodsMapper.selectByPrimaryKey(shopOrder.getGoodsId());
            BeanUtils.copyProperties(shopOrderVO,shopOrder);
            BeanUtils.copyProperties(shopOrderVO,goods);
            return shopOrderVO;
        }
        return null;
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

        return null;
    }
}
