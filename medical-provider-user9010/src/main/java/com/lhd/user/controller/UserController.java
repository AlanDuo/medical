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
}
