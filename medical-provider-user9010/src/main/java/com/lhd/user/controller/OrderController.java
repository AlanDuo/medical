package com.lhd.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.user.common.ResponseData;
import com.lhd.user.common.TableVO;
import com.lhd.user.dto.UserDTO;
import com.lhd.user.handler.LoginUserHolder;
import com.lhd.user.service.OrderService;
import com.lhd.user.vo.ShopOrderListVO;
import com.lhd.user.vo.ShopOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author alan
 * @date 2021/2/24
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private LoginUserHolder loginUserHolder;
    @Autowired
    private OrderController(OrderService orderService, LoginUserHolder loginUserHolder){
        this.orderService=orderService;
        this.loginUserHolder=loginUserHolder;
    }

    /**
     * ================商城订单==============
     */

    @GetMapping("/shopOrderList")
    public TableVO shopOrderList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "page",defaultValue = "20") Integer limit){
        UserDTO  userDTO=loginUserHolder.getCurrentUser();
        PageHelper.startPage(page,limit);
        List<ShopOrderListVO> orderListVOList=orderService.getShopOrderList(userDTO.getId());
        PageInfo pageInfo=new PageInfo<>(orderListVOList);
        return new TableVO(pageInfo,orderListVOList);
    }
    @GetMapping("/shopOrderDetail")
    public ResponseData shopOrderDetail(Long orderId){
        ShopOrderVO shopOrderVO=orderService.getShopOrderDetail(orderId);
        return ResponseData.ok().putDataValue(shopOrderVO);
    }

    /**
     * ================问诊订单==============
     */


}
