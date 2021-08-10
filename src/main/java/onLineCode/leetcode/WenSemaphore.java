package onLineCode.leetcode;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/14 2:51 下午
 * @description：自建信号量
 * @modified By：
 * @version: 1$
 */
public class WenSemaphore {
    WenAQS aqs = new WenAQS(){
        @Override
        public int tryAcquireShared() {
            for (;;){
                int count = getState().get();
                int n = count - 1;
                if (count <= 0 || n < 0){
                    return -1;
                }
                if (getState().compareAndSet(count,n)){
                    return 1;
                }
            }
        }

        @Override
        public boolean tryReleaseShared() {
            return getState().incrementAndGet() >= 0;
        }
    };

    public WenSemaphore(int count){
        aqs.getState().set(count);
    }
    public void acquire(){
        aqs.acquireShared();
    }
    public void release(){
        aqs.releaseShared();
    }

}
