package com.example.service.Impl;

import com.example.cache.RedisCache;
import com.example.dao.EmployeeDao;
import com.example.domain.webservice.Employee;
import com.example.service.EmployeeService;
import com.example.util.SerializableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lvxiao on 2018/9/3.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static final String CACHE_NAME = "employee";
    @Autowired
    private EmployeeDao employeeDao;

//    @Autowired
//    @Qualifier(value = "UserCache")
//    private RedisCache redisCache;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Employee> selectEmployeeByIds(List<Integer> ids) {
        List<Employee> employees = new ArrayList<>();
//        List<Employee> employees = employeeDao.selectEmployeeByIds(ids);
        redisTemplate.executePipelined((RedisCallback<Object>) redisConnection -> {
            Iterator<Integer> iterator = ids.iterator();
            while (iterator.hasNext()) {
                int id = iterator.next();
                byte[] bytes = redisConnection.get(("Employee" + id).getBytes());
                System.out.println(bytes);
                if (bytes != null) {
                    employees.add((Employee) SerializableUtil.unserialize(bytes));
                } else {
                    employees.add(selectEmployeeById(id));
                }
            }
            return null;
        });
        return employees;
    }

    @Cacheable(value = "Employee",key = "'Employee' + #id")
    @Override
    public Employee  selectEmployeeById(int id) {
        System.out.println("~~~~~这个应该是没有使用缓存~~~~~~");
        return employeeDao.selectEmployeeById(id);
    }

    @Cacheable(value = "Employee",key = "'Employee' + #id")
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
