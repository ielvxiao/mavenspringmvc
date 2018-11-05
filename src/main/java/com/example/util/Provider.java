package com.example.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lvxiao
 * @Date 2018/11/5 21:12
 * @Description: TODO
 * @Version V1.0
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo_provider.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
