package com.example.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by lvxiao on 2018/8/30.
 */
public class Test {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(TestWebService.class);
        factoryBean.setAddress("http://localhost:8080/cxf/test?wsdl");
        TestWebService testWebService = (TestWebService) factoryBean.create();
        System.out.println(testWebService.say());
    }
}
