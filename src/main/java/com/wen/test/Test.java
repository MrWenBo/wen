package com.wen.test;

import com.wen.config.AppConfig;
import com.wen.dao.LubanDao;
import com.wen.dao.LubanDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：wenbo
 * @date ：Created in 2021/7/23 7:24 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //LubanDao dao = annotationConfigApplicationContext.getBean(LubanDaoImpl.class);
//        LubanDaoImpl dao = (LubanDaoImpl) annotationConfigApplicationContext.getBean("lubanDaoImpl");
//        dao.get();

        LubanDao dao = (LubanDao) annotationConfigApplicationContext.getBean("lubanDao");
        dao.get();
    }

}
