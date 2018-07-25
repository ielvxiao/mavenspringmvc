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
    public void testSelectUserById() {
        User user = userService.selectUserById(1);
        Assert.assertNotNull("is not null", user);
        Assert.assertEquals("lvxiao", user.getName());
    }

    @Test
    public void testInsertUser() {
        User user = new User(0, "id0", 20);
        Assert.assertEquals(1, Long.parseLong(userService.addUser(user)+""));
    }
}
