package com.example.util;

import com.example.service.DubboTestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lvxiao
 * @Date 2018/11/5 21:14
 * @Description: TODO
 * @Version V1.0
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo_consumer.xml");
        context.start();
        DubboTestService service = (DubboTestService) context.getBean("demoService");
        System.out.println(service.sayHello("dubbo"));
    }
}
