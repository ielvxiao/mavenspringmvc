package com.example.webservice;



import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by lvxiao on 2018/8/11.
 */
@WebService
public class TestWebServiceImpl implements TestWebService{

    @Autowired
    private UserDao userDao;

    @Override
    public String say() {
        return userDao.selectUserById(1).getName();
    }

    @Override
    public void write() {
        System.out.println("调用了write");
    }
}
