package com.wen.rotation;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/26 8:51 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Weight {
    private Integer weight;
    private Integer curWeight;
    private String ip;

    public Weight(Integer weight, Integer curWeight, String ip) {
        this.weight = weight;
        this.curWeight = curWeight;
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(Integer curWeight) {
        this.curWeight = curWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
