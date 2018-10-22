package com.example.dao;

import com.example.domain.User;

/**
 * Created by lvxiao on 2018/7/24.
 */
public interface UserDao {
    User selectUserById(int id);

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);
}
