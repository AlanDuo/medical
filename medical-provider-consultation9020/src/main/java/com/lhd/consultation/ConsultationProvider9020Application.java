package com.lhd.consultation;

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
@MapperScan("com.lhd.consultation.dao")
public class ConsultationProvider9020Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsultationProvider9020Application.class,args);
    }
}
