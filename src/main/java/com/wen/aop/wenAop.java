package com.wen.aop;


import org.springframework.stereotype.Component;

/**
 * @author ：wenbo
 * @date ：Created in 2021/7/30 9:51 上午
 * @description：
 * @modified By：
 * @version: $
 */
//@AspectJ
@Component
public class wenAop {

    public void before(){
        System.out.println("在这之前");
    }
}
