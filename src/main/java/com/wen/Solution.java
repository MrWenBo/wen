package com.wen;

import onLineCode.struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
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
    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 8;
        A[4] = 9;
        int[] B = new int[]{4,5,6,7,10};
        merge(A,5,B,5);
        for (int num : A){
            System.out.println(num);
        }

    }

    public static void merge(int A[], int m, int B[], int n){
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0){
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while(j >= 0){
            A[index--] = B[j--];
        }
    }

}
