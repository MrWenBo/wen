package test.leetcode;


public class Alibole {
    int count = 0;
    public static void main(String[] args) {

        Alibole alibole = new Alibole();
        MyRunnable myRunnable = alibole.new MyRunnable();
        for (int i = 0; i < 19; i++) {
            new Thread(myRunnable).start();
        }
    }
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (count >= 100) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":count:" + (++count));
                        Thread.yield();
                    }
                }
            }
        }
}


