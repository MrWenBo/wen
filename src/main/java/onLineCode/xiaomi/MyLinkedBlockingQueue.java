package onLineCode.xiaomi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/9 10:51 上午
 * @description：
 * @modified By：
 * @version: $
 */
public class MyLinkedBlockingQueue<E> {
    public MyLinkedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    static class Node<E>{
        E item;
        Node<E> next;
        public Node(E x){ item = x; }
    }
    private final int capacity;
    private final AtomicInteger count = new AtomicInteger();

    Node<E> head;
    Node<E> last;

    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();

    private final ReentrantLock putLock = new ReentrantLock();
    private final Condition notFull = putLock.newCondition();

    private void signalNotEmpty(){
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        }finally {
            takeLock.unlock();
        }
    }
    private void signalNotFull(){
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        }finally {
            putLock.unlock();
        }
    }

    private void enqueue(Node<E> node){
        last = last.next = node;
    }
    private E dequeue(){
        Node<E> h = head;
        Node<E> first = h.next;
        h.next = h;
        head = first;
        E x = first.item;
        first.item = null;
        return x;
    }
    public void put(E e) throws InterruptedException{
        if (e == null) {
            throw new NullPointerException();
        }
        int c = -1;
        Node<E> node = new Node<E>(e);
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try {
            while (count.get() == capacity){
                notFull.await();
            }
            enqueue(node);
            c = count.getAndIncrement();
            if(c + 1 < capacity){
                notFull.signal();
            }
        }finally {
            putLock.unlock();
        }
        if (c == 0){
            signalNotEmpty();
        }
    }
    public E take() throws InterruptedException{
        E x;
        int c = -1;
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0){
                notEmpty.await();
            }
            x = dequeue();
            c = count.getAndDecrement();
            if(c > 0 ){
                notEmpty.signal();
            }
        }finally {
            takeLock.unlock();
        }
        if (c == capacity){
            signalNotFull();
        }
        return x;
    }
}
