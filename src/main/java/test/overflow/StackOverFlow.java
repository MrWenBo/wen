package test.overflow;

/**
 * @author ：wenbo
 * @date ：Created in 2021/2/20 4:15 下午
 * @description：栈溢出
 * @modified By：
 * @version: $
 */
public class StackOverFlow {
    private static int count;

    public static void count(){
        try {
            count++;
            count();
        } catch (Throwable e) {
            System.out.println("最大深度:"+count);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        count();
    }
}
