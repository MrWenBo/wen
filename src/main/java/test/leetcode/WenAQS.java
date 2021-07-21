package test.leetcode;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * @author wenbo
 */
public class WenAQS {
    // acquire 定义资源抢占逻辑，如果没有拿到，则等待
    // tryAcquire tryAcquireShare 实际执行占用资源的操作
    // release releaseShared 定义资源释放逻辑，通知后续节点占用
    // tryRelease tryReleaseShared 实际执行资源释放的操作，具体的AQS使用者实现

    volatile AtomicReference<Thread> owner = new AtomicReference<>();
    volatile LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();
    volatile AtomicInteger state = new AtomicInteger();



    public int tryAcquireShared(){
        throw new UnsupportedOperationException();
    }
    public  void acquireShared(){
        boolean addQueue = true;
        while (tryAcquireShared() < 0){
            if(addQueue){
                waiters.offer(Thread.currentThread());
                addQueue = false;
            }else {
                LockSupport.park();
            }
        }
        waiters.remove(Thread.currentThread());
    }

    public  boolean tryReleaseShared(){
        throw new UnsupportedOperationException();
    }

    public void releaseShared(){
        if (tryReleaseShared()) {
            Iterator<Thread> iterator = waiters.iterator();
            while (iterator.hasNext()) {
                Thread next = iterator.next();
                LockSupport.unpark(next);
            }
        }
    }


    public  boolean tryAcquire(){
        throw new UnsupportedOperationException();
    }

    public  boolean tryRelease(){
        throw new UnsupportedOperationException();
    }


    public void acquire(){
        boolean addQueue = true;
        while (!tryAcquire()){
            if(addQueue){
                waiters.offer(Thread.currentThread());
                addQueue = false;
            }else {
                LockSupport.park();
            }
        }
        waiters.remove(Thread.currentThread());
    }

    public void release(){
        if (tryRelease()) {
            // 通知等待者
            Iterator<Thread> iterator = waiters.iterator();
            while (iterator.hasNext()) {
                Thread next = iterator.next();
                LockSupport.unpark(next);
            }
        }
    }

    public AtomicInteger getState() {
        return state;
    }

    public void setState(AtomicInteger state) {
        this.state = state;
    }
}
