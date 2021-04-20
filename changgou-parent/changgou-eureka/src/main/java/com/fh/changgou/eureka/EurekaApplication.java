package com.fh.changgou.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 微服务注册中心springboot的启动类
 * @author fh
 * @create 2021-04-19 下午4:37
 */
@SpringBootApplication
@EnableEurekaServer  //开启eureka注册中心服务
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}
