package onLineCode.sync;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/19 10:57 下午
 * @description：锁粗化，运行时
 * @modified By：
 * @version: 1.0$
 */
public class SynchronizedStrong {
    int i;
    public void  test(Object arg){
        synchronized(this){
            i++;
        }
        synchronized(this){
            i++;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000000; i++) {
            new SynchronizedStrong().test("a");
        }
    }
}
