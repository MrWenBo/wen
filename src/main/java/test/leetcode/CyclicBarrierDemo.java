package test.leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/14 3:55 下午
 * @description：线程栅栏
 * @modified By：
 * @version: 1$
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException{
        LinkedBlockingQueue<String> sqls = new LinkedBlockingQueue<>();
        CyclicBarrier barrier = new CyclicBarrier(4,()->{
            System.out.println("有4个线程执行了：" + Thread.currentThread());
            for (int i = 0; i < 4; i++) {
                System.out.println(sqls.poll());
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    sqls.add("data - " + Thread.currentThread());
                    Thread.sleep(1000L);
                    barrier.await();
                    System.out.println(Thread.currentThread() + "插入完毕");
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
