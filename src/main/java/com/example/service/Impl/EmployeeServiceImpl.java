package com.example.service.Impl;

import com.example.dao.EmployeeDao;
import com.example.domain.webservice.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvxiao on 2018/9/3.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static final String CACHE_NAME = "employee";
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> selectEmployeeByIds(List<Integer> ids) {
        return employeeDao.selectEmployeeByIds(ids);
    }

    @Cacheable(value = "skyCache",key = "#root.target.CACHE_NAME + #id")
    @Override
    public Employee  selectEmployeeById(int id) {
        System.out.println("~~~~~这个应该是没有使用缓存~~~~~~");
        return employeeDao.selectEmployeeById(id);
    }

    @Cacheable(value = "skyCache",key = "#root.target.CACHE_NAME + #id")
    @Override
    public Employee test(int id) {
        System.out.println("这个是测试对比");
        return employeeDao.test(id);
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeDao.selectAllEmployees();
    }
}
