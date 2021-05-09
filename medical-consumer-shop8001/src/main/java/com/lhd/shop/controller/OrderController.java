package com.lhd.shop.controller;

import com.lhd.shop.common.ResponseData;
import com.lhd.shop.dto.OrderAddDTO;
import com.lhd.shop.dto.OrderUpdateDTO;
import com.lhd.shop.handler.LoginUserHolder;
import com.lhd.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author alan
 * @date 2021/4/3
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private LoginUserHolder loginUserHolder;

    @PostMapping("/add_wait_to_pay")
    public Object addToWaitToPay(String goodsIds, String amounts){
        System.out.println(goodsIds+"  "+amounts);
        Long userId=loginUserHolder.getCurrentUser().getId();
        String[] idList = goodsIds.split(" ");
        String[] amountList=amounts.split(" ");
        for(int i=0;i<idList.length;i++){
            long goodsId=Long.parseLong(idList[i]);
            int amount=Integer.parseInt(amountList[i]);
            orderService.addToWaitToPay(userId,goodsId,amount);
        }
        return ResponseData.ok();
    }
    @GetMapping("/wait_to_pay")
    public Object getWaitToPayList(){
        Long userId=loginUserHolder.getCurrentUser().getId();
        return orderService.getWaitToPayList(userId);
    }
    @PostMapping("/add")
    public Object addOrder(OrderAddDTO orderAddDTO){
        Long userId=loginUserHolder.getCurrentUser().getId();
        orderAddDTO.setUserId(userId);
        return orderService.addOrder(orderAddDTO);
    }
    @PostMapping("/pay")
    public Object payOrder(Long orderNum){
        return orderService.payOrder(orderNum);
    }
    @DeleteMapping("/cancel")
    public Object cancelOrder(Long orderNum){
        return orderService.cancelOrder(orderNum);
    }
    @PutMapping("/update")
    public Object updateOrder(@RequestBody OrderUpdateDTO orderUpdateDTO){
        return orderService.updateOrder(orderUpdateDTO);
    }
}
