package test.Lock;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/15 4:19 下午
 * @description：全手写锁
 * @modified By：
 * @version: 1$
 */
public class BoLock implements Lock {
    volatile AtomicReference<Thread> owner = new AtomicReference<>();
    volatile LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    @Override
    public void lock() {
        boolean addQ = true;
        while (!tryLock()){
            if (addQ){
                waiters.offer(Thread.currentThread());
                addQ = false;
            }else {
                LockSupport.park();
            }
        }
        waiters.remove(Thread.currentThread());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return owner.compareAndSet(null,Thread.currentThread());
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        if (owner.compareAndSet(Thread.currentThread(),null)){
            Iterator<Thread> iterator = waiters.iterator();
            while (iterator.hasNext()){
                Thread waiter = iterator.next();
                LockSupport.unpark(waiter);
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
