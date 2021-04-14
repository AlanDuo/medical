package com.lhd.encyclopedias;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author alan
 * @date 2021/4/9
 */
@SpringBootApplication
@MapperScan("com.lhd.encyclopedias.dao")
@EnableCaching
@EnableDiscoveryClient
public class EncyclopediasProvider9030Application {
    public static void main(String[] args) {
        SpringApplication.run(EncyclopediasProvider9030Application.class,args);
    }
}
