package com.example.service.Impl;

import com.example.service.DubboTestService;

/**
 * @Author lvxiao
 * @Date 2018/11/5 20:45
 * @Description: TODO
 * @Version V1.0
 */
public class DubboTestServiceImpl implements DubboTestService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
