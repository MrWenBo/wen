package com.wen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/25 3:34 下午
 * @description：
 * @modified By：
 * @version: $
 */
@SpringBootApplication
@EnableEurekaClient
public class AppUserClient {

    public static void main(String[] args) {
        SpringApplication.run(AppUserClient.class);
    }
}
