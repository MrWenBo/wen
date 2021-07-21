package com.wen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/7/21 7:25 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Solution {
    private static volatile int i = 0;
    private static volatile int j = 0;
    private static volatile  boolean flag = false;
    private static Lock lock = new ReentrantLock();
    private static Object block = new Object();
    public static void main(String[] args) {
        byLock();
    }

    public static void byLock(){
        new Thread(()->{
            while (i < 10){
                lock.lock();
                try{
                    while (!flag){
                        System.out.println(Thread.currentThread().getName() + ": " +i++);
                        flag = true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }).start();
        new Thread(()->{
            while (i < 10){
                lock.lock();
                try {
                    while (flag){
                        System.out.println(Thread.currentThread().getName() + ": " +i++);
                        flag = false;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }).start();
    }


    public static void bySync(){
        new Thread(()->{
            while(i < 10){
                synchronized (block){
                    if (flag){
                        try {
                            block.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + ": " +i++);
                        flag = true;
                        block.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(()->{
            while(i < 10){
                synchronized (block){
                    if (!flag){
                        try {
                            block.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + ": " +i++);
                        flag = false;
                        block.notifyAll();
                    }
                }
            }
        }).start();
    }

    public static int[] sort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(nums[j] < nums[i]){
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
