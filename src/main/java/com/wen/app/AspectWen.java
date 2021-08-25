package com.wen.app;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/13 10:49 上午
 * @description：
 * @modified By：
 * @version: $
 */

@Component
@Aspect
public class AspectWen {
    @Pointcut("execution(* com.wen.dao.*.*(..))")
    public void pointCut(){
        System.out.println("Proxy Before!");
    }
}
