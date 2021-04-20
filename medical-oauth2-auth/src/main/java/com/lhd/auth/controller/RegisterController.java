package com.lhd.auth.controller;

import com.lhd.auth.domain.UserRegisterDTO;
import com.lhd.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("/user_register")
    public Map<String,Object> registerUser(@RequestBody UserRegisterDTO registerDTO){
        System.out.println(registerDTO.getUsername());
        userService.registerUser(registerDTO);
        Map<String,Object> map=new HashMap<>();
        map.put("code",200);
        return map;
    }
}
