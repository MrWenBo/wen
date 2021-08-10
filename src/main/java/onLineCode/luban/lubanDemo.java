package onLineCode.luban;

import java.util.concurrent.TimeUnit;

/**
 * @author ：wenbo
 * @date ：Created in 2021/6/28 9:49 上午
 * @description：
 * @modified By：
 * @version: $
 */
public class lubanDemo {
    final static int MAX = 5;
    static volatile int init_value = 0;
    public static void main(String[] args) {
        new Thread(()->{
            int localValue = init_value;
            while(localValue < MAX){
                if (localValue < MAX){
                    System.out.println("The inti_value:" + init_value);
                    localValue = init_value;
                }
            }
        },"reader").start();

        new Thread(()->{
            int localValue = init_value;
            while(localValue < MAX){
                System.out.println("update init_value:" + (++localValue));
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"update").start();
    }
}
