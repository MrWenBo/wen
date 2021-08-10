package com.wen.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author ：wenbo
 * @date ：Created in 2021/7/23 6:18 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {
    public void testBean(){
        System.out.println("testBean");
    }

    @Override
    public Object getObject() throws Exception {
        return new TempDaoFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return TempDaoFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
