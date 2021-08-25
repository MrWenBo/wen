package onLineCode.xiaomi;

/**
 * @author ：wenbo
 * @date ：Created in 2021/2/24 3:38 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class BlockingQueue {

    private final Object[] items;
    private int takeIndex;
    private int putIndex;
    private int count;

    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        items = new Object[capacity];
    }

    private void enqueue(Object e) {
        items[putIndex] = e;
        if (++putIndex == items.length) {
            putIndex = 0;
        }
        count++;
    }

    private Object dequeue() {
        Object e = items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length) {
            takeIndex = 0;
        }
        count--;
        return e;
    }

    public void put(Object e) throws InterruptedException {
        synchronized (this) {
            while (count == items.length) {
                this.wait();
            }
            enqueue(e);
            this.notifyAll();
        }
    }

    public Object take() throws InterruptedException {
        synchronized (this) {
            while (count == 0) {
                this.wait();
            }
            Object e = dequeue();
            this.notifyAll();
            return e;
        }
    }

    /** 显式锁 *//*
    private final ReentrantLock lock = new ReentrantLock();

    *//** 锁对应的条件变量 *//*
    private final Condition condition = lock.newCondition();

    *//**
     * 将指定元素插入队列
     *
     * @param e 待插入的对象
     *//*
    public void put(Object e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == items.length) {
                // 队列已满时进入休眠
                // 使用与显式锁对应的条件变量
                condition.await();
            }

            // 执行入队操作，将对象e实际放入队列中
            enqueue(e);

            // 通过条件变量唤醒休眠线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    *//**
     * 从队列中弹出一个元素
     *
     * @return  被弹出的元素
     *//*
    public Object take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                // 队列为空时进入休眠
                // 使用与显式锁对应的条件变量
                condition.await();
            }

            // 执行出队操作，将队列中的第一个元素弹出
            Object e = dequeue();

            // 通过条件变量唤醒休眠线程
            condition.signalAll();

            return e;
        } finally {
            lock.unlock();
        }
    }*/
}
