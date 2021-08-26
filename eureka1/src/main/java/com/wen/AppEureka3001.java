package com.wen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/25 9:33 下午
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka3001 {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka3001.class);
    }
}
