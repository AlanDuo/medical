package com.lhd.manager.controller;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.manager.common.ResponseData;
import com.lhd.manager.common.TableVO;
import com.lhd.manager.dto.ShopOrderUpdateDTO;
import com.lhd.manager.service.OrderService;
import com.lhd.manager.vo.ShopOrderInfoVO;
import com.lhd.manager.vo.ShopOrderListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author alan
 * @date 2021/3/20
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @GetMapping("/shop_order_list")
    public TableVO getShopOrderList(String orderNumber,String username, String goodsName, String createStartTime, String createEndTime,Byte status,
                                    @RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        Date start= Convert.toDate(createStartTime);
        Date end=Convert.toDate(createEndTime);
        Map<String,Object> map=orderService.getShopOrderList(orderNumber,username,goodsName,status,start,end);
        PageInfo pageInfo=(PageInfo)map.get("pageInfo");
        List<ShopOrderListVO> shopOrderList=(List<ShopOrderListVO>)map.get("list");
        return new TableVO(pageInfo,shopOrderList);
    }

    @GetMapping("/shop_order_info/{orderId}")
    public ResponseData getShopOrderInfo(@PathVariable("orderId")Long orderId){
        ShopOrderInfoVO orderInfoVO=orderService.getShopOrderInfo(orderId);
        return ResponseData.ok().putDataValue(orderInfoVO);
    }

    @PutMapping("/update_shop_order")
    public ResponseData updateShopOrder(@RequestBody ShopOrderUpdateDTO updateDTO){
        boolean result=orderService.updateShopOrder(updateDTO);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }

}
