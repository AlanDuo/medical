package com.lhd.manager.service.impl;

import com.github.pagehelper.PageInfo;
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
import java.math.BigDecimal;
import java.util.*;

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
    public Map<String,Object> getShopOrderList(String orderNumber, String username, String goodsName, Byte status, Date createStartTime, Date createEndTime) {
        ShopOrderExample shopOrderExample=new ShopOrderExample();
        ShopOrderExample.Criteria orderCriteria=shopOrderExample.createCriteria();
        if(null!=orderNumber && !"".equals(orderNumber.trim())){
            orderCriteria.andOrderNumEqualTo(Long.parseLong(orderNumber));
        }
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
        orderCriteria.andStatusEqualTo(status);
        List<ShopOrder> shopOrderList=shopOrderMapper.selectByExample(shopOrderExample);
        Map<String, Object> map=new HashMap<>(2);
        PageInfo pageInfo=new PageInfo<>(shopOrderList);
        map.put("pageInfo",pageInfo);
        List<ShopOrderListVO> shopOrderListVOList=new ArrayList<>();
        for(ShopOrder shopOrder:shopOrderList){
            ShopOrderListVO shopOrderListVO=new ShopOrderListVO();
            BeanUtils.copyProperties(shopOrder,shopOrderListVO);
            if(shopOrder.getLogisticsNum()==null){
                shopOrderListVO.setLogisticsNum("未发货");
            }
            Goods goods=goodsMapper.selectByPrimaryKey(shopOrder.getGoodsId());
            BigDecimal totalPrice=goods.getWholesalePrice().multiply(new BigDecimal(shopOrder.getAmount()));
            shopOrderListVO.setTotalPrice(totalPrice);
            shopOrderListVOList.add(shopOrderListVO);
        }
        map.put("list",shopOrderListVOList);
        return map;
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
                byte status=3;
                shopOrder.setStatus(status);
            }
        }

        return shopOrderMapper.updateByPrimaryKeySelective(shopOrder)>0;
    }
}
