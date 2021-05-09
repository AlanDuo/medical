package com.lhd.shop.controller;

import com.lhd.shop.common.ResponseData;
import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import com.lhd.shop.service.OrderService;
import com.lhd.shop.vo.WaitToPayListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alan
 * @date 2021/4/1
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/add_wait_to_pay")
    public ResponseData addToWaitToPay(Long userId,Long goodsId,Integer amount){
        orderService.addWaitToPay(userId, goodsId, amount);
        return ResponseData.ok();
    }

    @GetMapping("/wait_to_pay")
    public ResponseData getWaitToPayList(Long userId){
        List<WaitToPayListVO> waitToPayList=orderService.getWaitToPayList(userId);
        return ResponseData.ok().putDataValue(waitToPayList);
    }

    @PostMapping("/add")
    public ResponseData addOrder(OrderAddDTO orderAddDTO){
        boolean result=orderService.addOrder(orderAddDTO);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }
    @PostMapping("/pay")
    public ResponseData payOrder(Long orderNum){
        boolean result=orderService.payOrder(orderNum);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }
    @DeleteMapping("/cancel")
    public ResponseData cancelOrder(Long orderNum){
        boolean result=orderService.cancelOrder(orderNum);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }
    @PutMapping("/update")
    public ResponseData updateOrder(@RequestBody OrderUpdateDTO orderUpdateDTO){
        boolean result=orderService.updateOrder(orderUpdateDTO);
        if(result){
            return ResponseData.ok();
        }
        return ResponseData.error();
    }


}
