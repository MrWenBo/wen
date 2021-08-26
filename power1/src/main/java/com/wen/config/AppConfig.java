package com.wen.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/25 7:19 下午
 * @description：
 * @modified By：
 * @version: $
 */
@ComponentScan("com")
@Configuration
public class AppConfig {
//    @Bean
//    public TomcatServletWebServerFactory tomcat(){
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.setPort(6001);
//        return  tomcat;
//    }
}
