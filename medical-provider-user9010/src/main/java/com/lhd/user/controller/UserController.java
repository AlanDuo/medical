package com.lhd.user.controller;

import com.lhd.user.common.ResponseData;
import com.lhd.user.dto.FeedbackDTO;
import com.lhd.user.dto.UserDTO;
import com.lhd.user.dto.UserRegisterDTO;
import com.lhd.user.entities.User;
import com.lhd.user.handler.LoginUserHolder;
import com.lhd.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    public ResponseData registerUser(UserRegisterDTO registerDTO){
        System.out.println(registerDTO.getUsername());
        userService.registerUser(registerDTO);
        return ResponseData.ok();
    }

    @GetMapping("/info")
    public ResponseData userInfo(){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        User user=userService.getUserById(userDTO.getId());
        return ResponseData.ok().putDataValue(user);
    }
    @PostMapping("/feedback")
    public ResponseData newFeedback(FeedbackDTO feedbackDTO){
        UserDTO userDTO=loginUserHolder.getCurrentUser();
        feedbackDTO.setUserId(userDTO.getId());
        if(userService.addFeedback(feedbackDTO)) {
            return ResponseData.ok();
        }
        return ResponseData.error();
    }
}
