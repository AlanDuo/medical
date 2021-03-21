package com.lhd.manager.service;

import com.lhd.manager.dto.ShopOrderUpdateDTO;
import com.lhd.manager.vo.ShopOrderInfoVO;
import com.lhd.manager.vo.ShopOrderListVO;

import java.util.Date;
import java.util.List;

/**
 * @author alan
 * @date 2021/3/20
 */
public interface OrderService {
    List<ShopOrderListVO> getShopOrderList(String username, String goodsName, Date createStartTime,Date createEndTime);
    ShopOrderInfoVO getShopOrderInfo(Long orderId);
    boolean updateShopOrder(ShopOrderUpdateDTO updateDTO);
}
