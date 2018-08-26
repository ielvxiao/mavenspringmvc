package com.example.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by lvxiao on 2018/8/26.
 */
public class WebserviceTest {
    public static void main(String[] args) {
        // http://localhost:8888/cxf/test?wsdl
        //创建WebService客户端代理工厂
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        //注册WebService接口
        factory.setAddress("http://localhost:8888/cxf/test?wsdl");
        TestWebService service = (TestWebService) factory.create();
        //调用webservice接口
        String name = service.say();
        System.out.println(name);
    }
}
