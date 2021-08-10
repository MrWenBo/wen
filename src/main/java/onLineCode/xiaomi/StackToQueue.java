package onLineCode.xiaomi;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/20 2:38 下午
 * @description：2栈形成1个队列
 * @modified By：
 * @version: 1$
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    public void push(int val){
        lock1.lock();
        try {
            stack1.add(val);
        }finally {
            lock1.unlock();
        }
    }

    public Integer pop(){

        if (stack2.size() == 0){
            while (stack1 != null){
                Integer temp = stack1.peek();
                stack2.push(temp);
                stack1.pop();
            }
        }
        int res = stack2.pop();
        return res;
    }
}
