package com.wen.rotation;

import com.wen.ServerIps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/26 8:54 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class RoundRobin {
    private static Map<String, Weight> weightMap = new HashMap<>();
    public static String getServer(){
        int totalWeight = ServerIps.MAP_LIST.values().stream().reduce(0,(w1,w2) -> w1 + w2);
        if(weightMap.isEmpty()){
            for (String ip: ServerIps.MAP_LIST.keySet()) {
                Integer weight = ServerIps.MAP_LIST.get(ip);
                weightMap.put(ip,new Weight(weight,weight,ip));
            }
        }
        Weight maxCurWeight = null;
        for(Weight weight : weightMap.values()){
            if(maxCurWeight == null || weight.getCurWeight() > maxCurWeight.getCurWeight()){
                maxCurWeight = weight;
            }
        }
        maxCurWeight.setCurWeight(maxCurWeight.getCurWeight() - totalWeight);
        for(Weight weight : weightMap.values()){
            weight.setCurWeight(weight.getCurWeight() + weight.getWeight());
        }
        return maxCurWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
