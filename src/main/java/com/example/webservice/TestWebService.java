package com.example.webservice;

import javax.jws.WebService;

@WebService
public interface TestWebService {
    String say();

    void write();
}
