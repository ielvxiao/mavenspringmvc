package com.example.service;

import com.example.domain.User;

/**
 * Created by lvxiao on 2018/7/24.
 */
public interface UserService {

    User selectUserById(Integer id);

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);
}
