package onLineCode.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Ali {
    static CountDownLatch cdl = new CountDownLatch(100);;
    static AtomicInteger ai = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException{
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+ai.getAndIncrement());
                    cdl.countDown();
                }
            });
        }
        cdl.await();
        System.out.println(ai.get());
        exec.shutdown();
    }
}
