package com.example.service;

import com.example.domain.webservice.Departments;

/**
 * Created by lvxiao on 2018/9/7.
 */
public interface DepartmentsService {
    Departments selectDepartmentById(String id);
}
