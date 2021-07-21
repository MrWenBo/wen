package test.leetcode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author wenbo
 */
public class WenLock implements Lock {

    WenAQS aqs = new WenAQS(){
        @Override
        public boolean tryAcquire() {
            return owner.compareAndSet(null,Thread.currentThread());
        }

        @Override
        public boolean tryRelease() {
            return owner.compareAndSet(Thread.currentThread(), null);
        }
    };

    @Override
    public void lock() {
        aqs.acquire();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        aqs.release();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
