package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/select")
    @ResponseBody
    public User selectUserById(Integer id) {
        return userService.selectUserById(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Integer addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Integer updateUser(User user) {
        return userService.updateUser(user);
    }
}
