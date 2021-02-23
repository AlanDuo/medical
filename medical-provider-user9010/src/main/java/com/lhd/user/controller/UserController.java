package com.lhd.user.controller;

import com.lhd.user.common.ResponseData;
import com.lhd.user.dto.UserDTO;
import com.lhd.user.entities.Bill;
import com.lhd.user.entities.User;
import com.lhd.user.handler.LoginUserHolder;
import com.lhd.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author alan
 * @date 2021/2/23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private LoginUserHolder loginUserHolder;
    @Autowired
    public UserController(UserService userService,LoginUserHolder loginUserHolder){
        this.userService=userService;
        this.loginUserHolder=loginUserHolder;
    }

    @GetMapping("/info")
    public ResponseData userInfo(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        User user=userService.getUserById(userDTO.getId());
        return ResponseData.ok().putDataValue(user);
    }
    @GetMapping("/wallet")
    public ResponseData userWallet(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        BigDecimal wallet=userService.getUserWallet(userDTO.getId());
        return ResponseData.ok().putDataValue(wallet);
    }
    @GetMapping("/bill")
    public ResponseData userBill(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        List<Bill> billList=userService.getUserBill(userDTO.getId());
        return ResponseData.ok().putDataValue(billList);
    }
    @PostMapping("/chargeWallet")
    public ResponseData chargeWallet(BigDecimal money,String purpose){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        userService.chargeWallet(userDTO.getId(),money,purpose);
        return ResponseData.ok();
    }
}
