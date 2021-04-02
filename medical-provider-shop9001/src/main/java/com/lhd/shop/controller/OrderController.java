package com.lhd.shop.controller;

import com.lhd.shop.common.ResponseData;
import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import com.lhd.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseData addOrder(@RequestBody OrderAddDTO orderAddDTO){
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
