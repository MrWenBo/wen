package test.Map;

/**
 * @author ：wenbo
 * @date ：Created in 2021/2/8 2:24 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class HashFunction {
    private int size;
    private int seed;

    public HashFunction(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    public int hash(String value) {
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + value.charAt(i);
        }
        int r = (size - 1) & result;
        return (size - 1) & result;
    }
}
