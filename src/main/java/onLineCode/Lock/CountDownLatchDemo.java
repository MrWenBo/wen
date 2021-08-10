package onLineCode.Lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/14 3:22 下午
 * @description：计数器
 * @modified By：
 * @version: 1$
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(10);


        for (int i = 0; i < 9; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread() + ".准备就绪，可以吃饭了！！");
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("我是"+ Thread.currentThread()+".我执行了-"+finalI+"调用了");
            }).start();
        }

        new Thread(()->{
            countDownLatch.countDown();
            try{
                countDownLatch.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("我是最后一条线程！");
        }).start();
    }
}
