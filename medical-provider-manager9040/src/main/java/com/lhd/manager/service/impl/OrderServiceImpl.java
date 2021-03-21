package com.lhd.manager.service.impl;

import com.lhd.manager.dao.GoodsMapper;
import com.lhd.manager.dao.ShopOrderMapper;
import com.lhd.manager.dao.UserMapper;
import com.lhd.manager.dto.ShopOrderUpdateDTO;
import com.lhd.manager.entity.Goods;
import com.lhd.manager.entity.ShopOrder;
import com.lhd.manager.entity.ShopOrderExample;
import com.lhd.manager.entity.User;
import com.lhd.manager.service.OrderService;
import com.lhd.manager.vo.ShopOrderInfoVO;
import com.lhd.manager.vo.ShopOrderListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private ShopOrderMapper shopOrderMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<ShopOrderListVO> getShopOrderList(String username, String goodsName, Date createStartTime, Date createEndTime) {
        ShopOrderExample shopOrderExample=new ShopOrderExample();
        ShopOrderExample.Criteria orderCriteria=shopOrderExample.createCriteria();
        if(null!=username && !"".equals(username.trim())){
            orderCriteria.andUsernameLike("%"+username+"%");
        }
        if(null!=goodsName && !"".equals(goodsName.trim())){
            orderCriteria.andGoodsNameLike("%"+goodsName+"%");
        }
        if(null!=createStartTime){
            orderCriteria.andCreateTimeGreaterThanOrEqualTo(createStartTime);
        }
        if(null!=createEndTime){
            orderCriteria.andCreateTimeLessThanOrEqualTo(createEndTime);
        }
        List<ShopOrder> shopOrderList=shopOrderMapper.selectByExample(shopOrderExample);
        List<ShopOrderListVO> shopOrderListVOList=new ArrayList<>();
        for(ShopOrder shopOrder:shopOrderList){
            ShopOrderListVO shopOrderListVO=new ShopOrderListVO();
            BeanUtils.copyProperties(shopOrder,shopOrderListVO);
            shopOrderListVOList.add(shopOrderListVO);
        }
        return shopOrderListVOList;
    }

    @Override
    public ShopOrderInfoVO getShopOrderInfo(Long orderId) {
        ShopOrder shopOrder=shopOrderMapper.selectByPrimaryKey(orderId);
        ShopOrderInfoVO orderInfoVO=new ShopOrderInfoVO();
        BeanUtils.copyProperties(shopOrder,orderInfoVO);
        Goods goods=goodsMapper.selectByPrimaryKey(shopOrder.getGoodsId());
        BeanUtils.copyProperties(goods,orderInfoVO);
        User user= userMapper.selectByPrimaryKey(shopOrder.getUserId());
        orderInfoVO.setPhone(user.getPhone());
        return orderInfoVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateShopOrder(ShopOrderUpdateDTO updateDTO) {
        ShopOrder shopOrder=shopOrderMapper.selectByPrimaryKey(updateDTO.getOrderId());
        if(updateDTO.getOperate()==1){
            //更新的操作是更新收货人信息
            if(null!=updateDTO.getUsername() && !"".equals(updateDTO.getUsername())) {
                shopOrder.setUsername(updateDTO.getUsername());
            }
            if(null!=updateDTO.getPhone() && !"".equals(updateDTO.getPhone())) {
                shopOrder.setPhone(updateDTO.getPhone());
            }
            if(null!=updateDTO.getAddress() && !"".equals(updateDTO.getAddress())){
                shopOrder.setAddress(updateDTO.getAddress());
            }
        }else{
            //更新操作为更新物流信息
            if(null!=updateDTO.getLogisticsNum() && !"".equals(updateDTO.getLogisticsNum())) {
                shopOrder.setLogisticsNum(updateDTO.getLogisticsNum());
                shopOrder.setDeliverTime(new Date());
            }
        }

        return shopOrderMapper.updateByPrimaryKeySelective(shopOrder)>0;
    }
}
