package com.lhd.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lhd.shop.dao")
@EnableCaching
public class ShopProvider9002Application {
    public static void main(String[] args) {
        SpringApplication.run(ShopProvider9002Application.class,args);
    }
}
