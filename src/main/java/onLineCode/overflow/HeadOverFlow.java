package onLineCode.overflow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wenbo
 * @date ：Created in 2021/2/20 4:18 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class HeadOverFlow {
    public static void main(String[] args) {
        List<Object> listObj = new ArrayList<Object>();
        for(int i = 0; i < 10; i++){
            Byte[] bytes = new Byte[1*1024*1024];
            listObj.add(bytes);
        }
        System.out.println("添加success");
    }
}
