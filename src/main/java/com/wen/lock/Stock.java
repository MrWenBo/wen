package com.wen.lock;

/**
 * @author ：wenbo
 * @date ：Created in 2021/9/7 9:05 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Stock {
    private static Integer COUNT = 1;

    public boolean reduceStock(){
        if(COUNT > 0){
            COUNT--;
            System.out.println(Thread.currentThread().getName() + "库存减少成功！");
            return true;
        }
        return false;
    }
}
