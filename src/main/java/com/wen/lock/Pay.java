package com.wen.lock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/9/7 9:15 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Pay {
    public void pay(){
        System.out.println(Thread.currentThread().getName() + "支付成功！");
    }
}
