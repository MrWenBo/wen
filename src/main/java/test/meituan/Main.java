package test.meituan;

/**
 * @author ：wenbo
 * @date ：Created in 2021/2/19 9:46 下午
 * @description：
 * @modified By：
 * @version: $
 */

import java.util.Stack;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static void push(int x){
            s1.add(x);
        }

        public static int pop(){
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    Integer temp = s1.peek();
                    s2.push(temp);
                    s1.pop();
                }
            }
            int res = s2.pop();
            return res;
        }
        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            push(1);
            System.out.println(pop());

            ExecutorService s = Executors.newFixedThreadPool(2);
            Main myhread3 = new Main();
            CountDownLatch c = new CountDownLatch(1);
            s.execute(myhread3.new MyThread3(c,"A"));
            s.execute(myhread3.new MyThread3(c,"B"));
            s.shutdown();
        }

    //CountDownLatch
    class MyThread3 implements Runnable{
        private CountDownLatch countDownLatch;
        private String name;
        public MyThread3(CountDownLatch countDownLatch,String name){
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        public MyThread3() {

        }

        @Override
        public void run(){
            if(name.equals("A")){
                try{
                    this.countDownLatch.await();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            this.countDownLatch.countDown();
        }



    }
}

    class Producer extends Thread{
        private Queue<Integer> q;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name,Queue<Integer> q,int maxSize){
            this.name = name;
            this.q = q;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){

            while(true){
                synchronized(q){
                    while(q.size() == maxSize){
                        try{
                            System.out.println("队列已满");
                            q.wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    q.offer(i++);
                    q.notifyAll();
                }
            }
        }
    }

     class Consumer extends Thread{
        private Queue<Integer> q;
        String name;
        int maxSize;

        public Consumer(String name,Queue<Integer> q,int maxSize){
            this.name = name;
            this.q = q;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                synchronized(q){
                    while(q.isEmpty()){
                        try{
                            System.out.println("队列为空");
                            q.wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    int x = q.poll();
                    q.notifyAll();
                }
            }
        }
    }

    class myThread1 implements Runnable{
        public int i = 2;
        @Override
        public void run(){
            Thread curThead = Thread.currentThread();
            synchronized(curThead){
                i++;
                curThead.notify();
            }
        }
    }

    class myThread2 implements Runnable{

        @Override
        public void run(){
            Thread curThead = Thread.currentThread();
            synchronized(curThead){
                while("myThread1".equals(curThead.getName())){
                    try{
                        curThead.wait(0);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("执行完毕");
                }
            }
        }
    }






