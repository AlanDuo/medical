package com.lhd.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhd.user.common.ResponseData;
import com.lhd.user.common.TableVO;
import com.lhd.user.dto.UserDTO;
import com.lhd.user.handler.LoginUserHolder;
import com.lhd.user.service.OrderService;
import com.lhd.user.vo.ConsultationOrderListVO;
import com.lhd.user.vo.PrescriptionVO;
import com.lhd.user.vo.ShopOrderListVO;
import com.lhd.user.vo.ShopOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/shopOrderList/{status}")
    public TableVO shopOrderList(@PathVariable("status") Byte status,@RequestParam(value = "page",defaultValue = "1") Integer page,
                                 @RequestParam(value = "page",defaultValue = "20") Integer limit){
        Long userId=loginUserHolder.getCurrentUser().getId();
        PageHelper.startPage(page,limit);
        Map<String,Object> map=orderService.getShopOrderList(userId,status);
        PageInfo pageInfo=(PageInfo)map.get("pageInfo");
        List<ShopOrderListVO> orderList=(List<ShopOrderListVO>)map.get("list");
        return new TableVO(pageInfo,orderList);
    }
    @GetMapping("/shopOrderDetail/{orderId}")
    public ResponseData shopOrderDetail(@PathVariable("orderId") Long orderId){
        ShopOrderVO shopOrderVO=orderService.getShopOrderDetail(orderId);
        return ResponseData.ok().putDataValue(shopOrderVO);
    }

    @PutMapping("/change_status")
    public ResponseData changeShopOrderStatus(Long orderId,Byte status){
        boolean result=orderService.updateShopOrderStatus(orderId, status);
        return ResponseData.ok();
    }

    /**
     * ================问诊订单==============
     */
    @GetMapping("/consultationOrderList")
    public TableVO consultationOrderList(Long userId,@RequestParam(value = "page",defaultValue = "1") Integer page,
                                              @RequestParam(value = "page",defaultValue = "20") Integer limit){
        PageHelper.startPage(page,limit);
        List<ConsultationOrderListVO> orderListVOList=orderService.getConsultationOrderList(userId);
        PageInfo pageInfo=new PageInfo<>(orderListVOList);
        return new TableVO(pageInfo,orderListVOList);
    }
    @GetMapping("/prescription/{orderId}")
    public ResponseData prescriptionOfOrder(@PathVariable("orderId")Long orderId){
        PrescriptionVO prescriptionVO=orderService.getPrescriptionOfOrder(orderId);
        return ResponseData.ok().putDataValue(prescriptionVO);
    }

}
