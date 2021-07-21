package test.demo;

/**
 * @author ：wenbo
 * @date ：Created in 2021/5/21 1:40 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(Demo.class.getClassLoader());
        ClassLoader loader = Demo.class.getClassLoader();
        while(loader != null){
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
