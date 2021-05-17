package com.lhd.manager.service.impl;

import com.lhd.manager.dao.GoodsMapper;
import com.lhd.manager.dao.ShopOrderMapper;
import com.lhd.manager.entity.Goods;
import com.lhd.manager.entity.GoodsExample;
import com.lhd.manager.entity.ShopOrder;
import com.lhd.manager.entity.ShopOrderExample;
import com.lhd.manager.service.DataAnalysisService;
import com.lhd.manager.utils.DateUtil;
import com.lhd.manager.vo.OrderSalesAndQuantityVO;
import com.lhd.manager.vo.ProfitVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/5/16
 */
@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {
    private static final Integer DIVIDE_DAY=1;
    private static final Integer MONTHS=12;

    @Resource
    private ShopOrderMapper orderMapper;
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<ShopOrder> getOrdersByTime(Date date1,Date date2){
        ShopOrderExample orderExample=new ShopOrderExample();
        ShopOrderExample.Criteria orderCriteria=orderExample.createCriteria();
        orderCriteria.andFinishTimeGreaterThanOrEqualTo(date1);
        orderCriteria.andFinishTimeLessThan(date2);
        return orderMapper.selectByExample(orderExample);
    }
    @Override
    public BigDecimal getSalesVolumeByTime(Date date1, Date date2) {
        BigDecimal volume=BigDecimal.ZERO;
        ShopOrderExample orderExample=new ShopOrderExample();
        ShopOrderExample.Criteria orderCriteria=orderExample.createCriteria();
        orderCriteria.andFinishTimeGreaterThanOrEqualTo(date1);
        orderCriteria.andFinishTimeLessThan(date2);
        List<ShopOrder> orderList=orderMapper.selectByExample(orderExample);
        for(ShopOrder order:orderList){
            Goods goods=goodsMapper.selectByPrimaryKey(order.getGoodsId());
            volume=volume.add(goods.getWholesalePrice().multiply(new BigDecimal(order.getAmount())));
        }
        return volume;
    }
    @Override
    public Map<Integer, OrderSalesAndQuantityVO> monthlySales(Integer year) {
        Map<Integer,OrderSalesAndQuantityVO> map=new HashMap<>(12);
        Date dateStart=null;
        Date dateEnd=null;
        for(int i=1;i<=MONTHS;i++){
            BigDecimal count=BigDecimal.ZERO;
            dateStart= DateUtil.parseDate(year,i,DIVIDE_DAY);
            dateEnd=DateUtil.parseDate(year,i+1,DIVIDE_DAY);
            List<ShopOrder> orders=getOrdersByTime(dateStart,dateEnd);
            for(ShopOrder order:orders){
                Goods goods=goodsMapper.selectByPrimaryKey(order.getGoodsId());
                count=count.add(goods.getWholesalePrice().multiply(new BigDecimal(order.getAmount())));
            }
            OrderSalesAndQuantityVO salesAndQuantityVO=new OrderSalesAndQuantityVO();
            salesAndQuantityVO.setOrderQuantity(orders.size());
            salesAndQuantityVO.setSalesVolume(count);
            map.put(i,salesAndQuantityVO);
        }
        return map;
    }
    @Override
    public Map<Integer, ProfitVO> getEachMonthProfit(Integer year) {
        Map<Integer,ProfitVO> map=new HashMap<>(12);
        for(int i=1;i<=MONTHS;i++) {
            Date date1 = DateUtil.parseDate(year,i);
            Date date2 = DateUtil.parseDate(year,i+1);

            BigDecimal salesVolume=getSalesVolumeByTime(date1,date2);
            GoodsExample applyExample=new GoodsExample();
            GoodsExample.Criteria applyCriteria=applyExample.createCriteria();
            applyCriteria.andPurchaseTimeGreaterThanOrEqualTo(date1);
            applyCriteria.andPurchaseTimeLessThan(date2);
            List<Goods> goodsApplyList=goodsMapper.selectByExample(applyExample);
            BigDecimal cost=BigDecimal.ZERO;
            for(Goods goodsApply:goodsApplyList){
                if(null!=goodsApply.getPurchasePrice()) {
                    cost=cost.add(goodsApply.getPurchasePrice().multiply(new BigDecimal(goodsApply.getStock())));
                }
            }
            BigDecimal profit=salesVolume.subtract(cost);
            ProfitVO profitVO=new ProfitVO(salesVolume,cost,profit);
            map.put(i,profitVO);
        }

        return map;
    }

}
