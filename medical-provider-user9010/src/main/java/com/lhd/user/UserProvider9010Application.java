package com.lhd.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author alan
 * @date 2021/3/1
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@MapperScan("com.lhd.user.dao")
public class UserProvider9010Application {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider9010Application.class,args);
    }
}
