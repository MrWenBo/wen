package onLineCode.mayischool;

/**
 * @author ：wenbo
 * @date ：Created in 2021/6/28 1:29 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Test {
    final static int MAX = 99;
    static volatile int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
           while(count < MAX) {
                synchronized (lock){
                    if ((count & 1) == 0) {
                        System.out.println("t1: " + count++);
                    }
                }
            }
        },"t1").start();
        new Thread(()->{
            while(count < MAX){
                synchronized (lock){
                    if ((count & 1) == 1) {
                        System.out.println("t2: " + count++);
                    }
                }
            }
        },"t2").start();

    }

}
