package com.wen.dao;

import com.wen.invocationHandler.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author ：wenbo
 * @date ：Created in 2021/7/21 9:53 上午
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class LubanDaoImpl implements LubanDao, BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("lubanDaoImpl")){
            bean = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{LubanDao.class}, new MyInvocationHandler(bean));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public void get() {
        System.out.println("假装做了一些事儿！！");
    }
}
