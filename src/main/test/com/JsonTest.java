package com;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author lvxiao
 * Date 2018/11/18 6:15 PM
 * TODO: 描述信息
 * Version V1.0
 */
public class JsonTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        map.put("name", "lvxiao");
        map.put("age", 2);
        list.add(map);
        map1.put("list", list);
        String result = JSON.toJSONString(map1);
        System.out.println(result);
    }
}
