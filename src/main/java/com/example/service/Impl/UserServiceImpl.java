package com.example.service.Impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public Integer addUser(User user) {
        System.out.println(user.getName());
        return userDao.addUser(user);
    }
}
