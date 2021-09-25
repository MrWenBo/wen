package com.wen.lock;

import java.util.concurrent.locks.Lock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/9/7 9:17 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new UserThread(),"user1");
        Thread t2 = new Thread(new UserThread(),"user2");
        t1.start();
        t2.start();
    }

    static class UserThread implements Runnable{
        @Override
        public void run() {
            Lock lock = new ZkLock();

            new Order().createOrder();
            lock.lock();
            boolean res = new Stock().reduceStock();
            lock.unlock();
            if(res){
                System.out.println(Thread.currentThread().getName() + "库存减少成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "库存减少失败");
            }
        }
    }
}
