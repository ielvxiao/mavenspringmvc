package com.example.webservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvxiao on 2018/8/26.
 */
public class WebserviceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestWebService webService = (TestWebService) applicationContext.getBean("helloClient");
        String s = webService.say();
        System.out.println(s);
    }
}
