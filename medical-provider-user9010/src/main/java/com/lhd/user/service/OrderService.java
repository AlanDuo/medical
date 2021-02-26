package com.lhd.user.service;

import com.lhd.user.vo.ConsultationOrderListVO;
import com.lhd.user.vo.PrescriptionVO;
import com.lhd.user.vo.ShopOrderListVO;
import com.lhd.user.vo.ShopOrderVO;

import java.util.List;

/**
 * @author alan
 * @date 2021/2/24
 */
public interface OrderService {
    List<ShopOrderListVO> getShopOrderList(Long userId);
    ShopOrderVO getShopOrderDetail(Long orderId);
    List<ConsultationOrderListVO> getConsultationOrderList(Long userId);
    PrescriptionVO getPrescriptionOfOrder(Long orderId);

}
