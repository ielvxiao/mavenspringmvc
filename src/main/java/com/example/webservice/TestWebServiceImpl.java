package com.example.webservice;

/**
 * Created by lvxiao on 2018/8/11.
 */
public class TestWebServiceImpl implements TestWebService{

    @Override
    public String say() {
        return "这是我的第一个webservice测试";
    }

    @Override
    public void write() {
        System.out.println("调用了write");
    }
}
