package com.example.webservice;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lvxiao on 2018/8/11.
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class TestWebServiceImpl implements TestWebService {

    @Autowired
    private UserService userService;

    @WebMethod
    @Override
    public String say() {
        return userService.selectUserById(1).getName();
    }

    @WebMethod
    @Override
    public void write() {
        System.out.println("调用了write");
    }
}
