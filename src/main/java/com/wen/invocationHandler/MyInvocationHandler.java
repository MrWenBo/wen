package com.wen.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/2 8:29 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class MyInvocationHandler implements InvocationHandler {
    Object target;
    public MyInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        return method.invoke(target, args);
    }
}
