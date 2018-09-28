package com.exampale.service;

import com.example.domain.User;
import com.example.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lvxiao on 2018/7/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml","/dispatcher-servlet.xml"})
public class UserServeceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User(11, "id11", 11);
        userService.addUser(user);
    }

    @Test
    public void selectUserById() {
    userService.selectUserById(11);
    }

    @Test
    public void updateUser() {
        User user = new User(11, "id11_update", 11);
        userService.updateUser(user);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(11);
    }
}
