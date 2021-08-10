package onLineCode.sync;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/19 10:27 下午
 * @description：synchronized
 * @modified By：
 * @version: 1.0$
 */
public class SyncDemo {

    static Object temp =  new Object();

    public void sync(){
        synchronized (SyncDemo.class){
            try {
                System.out.println("start run: "+ Thread.currentThread());
                Thread.sleep(3000L);
                System.out.println("Over: " + Thread.currentThread());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public synchronized void reentrantLockSynchronized(Object arg){
        System.out.println(Thread.currentThread() + "start" + arg);
        if (arg == null){
            reentrantLockSynchronized(new Object());
        }
        System.out.println(Thread.currentThread() + "end" + arg);
    }

    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            new SyncDemo().sync();
//        }).start();
//        Thread.sleep(1000L);
//        new Thread(()->{
//            new SyncDemo().sync();
//        }).start();
        new SyncDemo().reentrantLockSynchronized(null);
    }
}
