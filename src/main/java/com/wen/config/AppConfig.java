package com.wen.config;

import com.wen.beanPostProcessor.MyImportBeanDefinitionRegister;
import com.wen.scan.LubanScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ：wenbo
 * @date ：Created in 2021/7/30 9:38 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@ComponentScan("com.wen")
@LubanScan
public class AppConfig {

}
