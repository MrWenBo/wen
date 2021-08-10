package com.wen.factoryBean;

import com.wen.dao.LubanDao;
import com.wen.invocationHandler.MyInvocationHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/2 5:47 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class MyFactoryBean implements FactoryBean, InvocationHandler {
    Class clazz;
    public MyFactoryBean(Class clazz){
        this.clazz = clazz;
    }
    @Override
    public Object getObject() throws Exception {
        Class[] clazzs = new Class[]{clazz};
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(),clazzs,this
        );
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        return null;
    }
}
