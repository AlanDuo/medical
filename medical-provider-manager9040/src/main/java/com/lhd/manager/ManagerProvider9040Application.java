package com.lhd.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author alan
 * @date 2021/3/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@MapperScan("com.lhd.manager.dao")
public class ManagerProvider9040Application {
    public static void main(String[] args) {
        SpringApplication.run(ManagerProvider9040Application.class,args);
    }
}
