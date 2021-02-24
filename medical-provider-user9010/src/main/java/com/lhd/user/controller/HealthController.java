package com.lhd.user.controller;

import com.lhd.user.handler.LoginUserHolder;
import com.lhd.user.service.HealthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alan
 * @date 2021/2/24
 */
@RestController
@RequestMapping("/health")
public class HealthController {
    private static final Logger LOGGER=LoggerFactory.getLogger(HealthController.class);
    private LoginUserHolder loginUserHolder;
    private HealthService healthService;
    @Autowired
    public HealthController(HealthService healthService,LoginUserHolder loginUserHolder){
        this.healthService=healthService;
        this.loginUserHolder=loginUserHolder;
    }


}
