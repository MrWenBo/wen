package test.Lock;

import test.leetcode.WenSemaphore;

import java.util.Random;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/14 2:14 下午
 * @description：信号量的例子
 * @modified By：
 * @version: 1.0.0$
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        int N = 8;
        WenSemaphore semaphore = new WenSemaphore(5);
        for (int i = 0; i < N; i++) {
            String vipNo = "vip-00" + i;
            new Thread(()->{
              try {
                  semaphore.acquire();
                  semaphoreDemo.service(vipNo);
                  semaphore.release();
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
            }).start();
        }
    }

    public void service(String vipNo) throws InterruptedException{
        System.out.println("迎来贵宾" + vipNo);
        Thread.sleep(new Random().nextInt(3000));
        System.out.println("送走一位");
    }
}
