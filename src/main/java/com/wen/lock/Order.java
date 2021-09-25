package com.wen.lock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/9/7 9:03 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Order {

    public void createOrder(){
        System.out.println(Thread.currentThread().getName() + "订单创建成功!");
    }
}
