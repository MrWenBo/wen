package test.Tencent;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/26 7:28 下午
 * @description：Tencent
 * @modified By：
 * @version: 1.0.0$
 */
public class Main {
    public int lenth(String s){
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int start = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start,last[index] + 1);
            ans = Math.max(ans, i - start + 1);
            last[index] = i;
        }
        return ans;
    }
}
