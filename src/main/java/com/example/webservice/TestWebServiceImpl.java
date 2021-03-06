package com.example.webservice;

import com.example.dao.UserDao;
import com.example.domain.User;
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
    private UserDao userDao;

    @WebMethod
    @Override
    public String say() {
        return userDao.selectUserById(1).getName();
    }

    @WebMethod
    @Override
    public void write() {
        System.out.println("调用了write");
    }

    @WebMethod
    @Override
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    @WebMethod
    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @WebMethod
    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }
}
