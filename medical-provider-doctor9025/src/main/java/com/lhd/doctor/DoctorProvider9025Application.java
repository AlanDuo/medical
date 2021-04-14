package com.lhd.doctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author alan
 * @date 2021/4/14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@MapperScan("com.lhd.doctor.dao")
public class DoctorProvider9025Application {
    public static void main(String[] args) {
        SpringApplication.run(DoctorProvider9025Application.class,args);
    }
}
