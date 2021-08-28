package com.wen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/26 8:08 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class ServerIps {
    public static final List<String> LIST = new ArrayList<>();
    static {
        LIST.add("192.168.1.1");
        LIST.add("192.168.1.2");
        LIST.add("192.168.1.3");
        LIST.add("192.168.1.4");
        LIST.add("192.168.1.5");
        LIST.add("192.168.1.6");
        LIST.add("192.168.1.7");
        LIST.add("192.168.1.8");
        LIST.add("192.168.1.9");
        LIST.add("192.168.1.10");
        LIST.add("192.168.1.11");
        LIST.add("192.168.1.12");
        LIST.add("192.168.1.13");
    }
    public static final Map<String, Integer> MAP_LIST = new HashMap<>();
    static {
        MAP_LIST.put("IPA",5);
        MAP_LIST.put("IPB",1);
        MAP_LIST.put("IPC",1);


    }
}
