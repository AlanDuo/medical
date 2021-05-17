package com.lhd.manager.service;

import com.lhd.manager.entity.ShopOrder;
import com.lhd.manager.vo.OrderSalesAndQuantityVO;
import com.lhd.manager.vo.ProfitVO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/5/16
 */
public interface DataAnalysisService {
    List<ShopOrder> getOrdersByTime(Date date1, Date date2);
    Map<Integer, OrderSalesAndQuantityVO> monthlySales(Integer year);
    Map<Integer, ProfitVO> getEachMonthProfit(Integer year);
    BigDecimal getSalesVolumeByTime(Date date1, Date date2);
}
