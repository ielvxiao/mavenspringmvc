package com.example.webservice;


import com.example.domain.User;

import javax.jws.WebService;

@WebService
public interface TestWebService {
    String say();

    void write();

    User selectUserById(Integer id);

    Integer addUser(User user);

    Integer updateUser(User user);
}
