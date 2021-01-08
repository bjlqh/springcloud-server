package com.lqh.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liqihua
 * @date 2020/6/3
 */
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "com.lqh.order.mapper*")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
