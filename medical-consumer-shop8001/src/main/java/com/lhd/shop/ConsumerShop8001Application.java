package com.lhd.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author alan
 * @date 2021/3/30
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerShop8001Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerShop8001Application.class,args);
    }
}
