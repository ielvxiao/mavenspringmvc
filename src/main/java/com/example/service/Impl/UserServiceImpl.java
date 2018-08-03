package com.example.service.Impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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
        LOGGER.debug("id为{}",id);
        return userDao.selectUserById(id);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public Integer addUser(User user) {
        LOGGER.debug("添加的用户为{}",user.getName());
        return userDao.addUser(user);
    }
}
