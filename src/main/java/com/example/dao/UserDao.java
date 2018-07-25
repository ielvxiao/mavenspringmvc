package com.example.dao;

import com.example.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Repository
public interface UserDao {
    User selectUserById(Integer id);

    Integer addUser(User user);
}
