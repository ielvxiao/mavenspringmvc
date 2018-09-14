package com.example.dao;

import com.example.domain.webservice.Departments;

/**
 * Created by lvxiao on 2018/9/7.
 */
public interface DepartmentsDao {
    Departments selectDepartmentById(String dept_no);
}
