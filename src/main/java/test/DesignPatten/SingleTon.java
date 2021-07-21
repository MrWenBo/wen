package test.DesignPatten;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/18 2:26 下午
 * @description：单例模式
 * @modified By：
 * @version: 1$
 */
public class SingleTon {
    private volatile static SingleTon instance;
    //如果在多线程下，一个线程进入了if (singleton == null)判断语句块，
    //还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
    //所以在多线程环境下不可使用这种方式。
    public static SingleTon getInstance(){
        if(instance != null){
            synchronized(SingleTon.class){
                if (instance != null){
                    instance = new SingleTon();
                }
            }
        }
        return  instance;
    }
}
