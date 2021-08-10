package com.wen.scan;

import com.wen.beanPostProcessor.MyImportBeanDefinitionRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/2 10:25 下午
 * @description：
 * @modified By：
 * @version: $
 */

@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitionRegister.class)
public @interface LubanScan {
}
