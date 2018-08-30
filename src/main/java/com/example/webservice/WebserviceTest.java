package com.example.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by lvxiao on 2018/8/26.
 */
public class WebserviceTest {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(TestWebService.class);
        factoryBean.setAddress("http://localhost:8888/cxf/test");
        TestWebService testWebService = (TestWebService) factoryBean.create();
        System.out.println(testWebService.selectUserById(1).getName());
    }
}
