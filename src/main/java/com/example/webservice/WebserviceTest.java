package com.example.webservice;

import com.example.domain.User;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by lvxiao on 2018/8/26.
 */
public class WebserviceTest {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(TestWebService.class);
        factoryBean.setAddress("http://localhost:8888/cxf/test?wsdl");
        TestWebService testWebService = (TestWebService) factoryBean.create();
        User user = new User();
        user.setId(1);
        user.setAge(28);
        user.setName("吕啸");
        System.out.println(testWebService.updateUser(user));
    }
}
