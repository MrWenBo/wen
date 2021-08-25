package com.wen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wenbo
 * @date ：Created in 2021/8/25 7:21 下午
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class PowerController {
    @RequestMapping("getPower.do")
    public Object getPower(){
        Map<String, Object> map = new HashMap<>();
        map.put("key", "power1");
        return  map;
    }
}
