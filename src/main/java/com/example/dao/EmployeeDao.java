package com.example.dao;

import com.example.domain.webservice.Employee;

import java.util.List;

/**
 * Created by lvxiao on 2018/9/3.
 */
public interface EmployeeDao {
    List<Employee> selectAllEmployees();

    Employee selectEmployeeById(int id);

    Employee test(int id);

    List<Employee> selectEmployeeByIds(List<Integer> ids);
}
