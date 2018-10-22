package com.exampale.service;

import com.example.domain.webservice.Employee;
import com.example.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvxiao on 2018/9/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml", "/dispatcher-servlet.xml"})
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void selectEmployeeByIds() {
        List<Integer> list = new ArrayList<>();
        for (int i = 10001; i < 10011; i++) {
            list.add(i);
        }
        List<Employee> employees = employeeService.selectEmployeeByIds(list);
        System.out.println(employees);
    }

    @Test
    public void selectEmployeeById() {
        Employee employee = employeeService.selectEmployeeById(10001);
    }
}
