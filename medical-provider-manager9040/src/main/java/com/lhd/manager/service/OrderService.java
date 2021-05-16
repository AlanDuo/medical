package com.lhd.manager.service;

import com.lhd.manager.dto.ShopOrderUpdateDTO;
import com.lhd.manager.vo.ShopOrderInfoVO;
import com.lhd.manager.vo.ShopOrderListVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/20
 */
public interface OrderService {
    Map<String,Object> getShopOrderList(String orderNumber, String username, String goodsName, Byte status, Date createStartTime, Date createEndTime);
    ShopOrderInfoVO getShopOrderInfo(Long orderId);
    boolean updateShopOrder(ShopOrderUpdateDTO updateDTO);
}
