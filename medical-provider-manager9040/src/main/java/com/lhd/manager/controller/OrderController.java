package com.lhd.manager.controller;

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
    public TableVO getShopOrderList(String username, String goodsName, Date createStartTime, Date createEndTim,
                                    @RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "page",defaultValue = "10")Integer limit){
        PageHelper.startPage(page,limit);
        List<ShopOrderListVO> shopOrderList=orderService.getShopOrderList(username,goodsName,createStartTime,createEndTim);
        PageInfo pageInfo=new PageInfo<>(shopOrderList);
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
