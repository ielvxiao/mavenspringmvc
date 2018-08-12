package com.example.webservice;

/**
 * Created by lvxiao on 2018/8/11.
 */
public class TestWebServiceImpl implements TestWebService{

    @Override
    public String say() {
        return "say";
    }

    @Override
    public void write() {
        System.out.println("调用了write");
    }
}
