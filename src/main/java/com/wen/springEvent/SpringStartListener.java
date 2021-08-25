package com.wen.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/23 8:29 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class SpringStartListener implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Spring application started");
    }
}
