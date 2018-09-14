package com.example.controller;

import com.example.domain.webservice.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lvxiao on 2018/9/3.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Employee> selecAllEmployee() {
        return employeeService.selectAllEmployees();
    }

    @RequestMapping("/select")
    @ResponseBody
    public Employee selectEmployeeById(int id) {
        return employeeService.selectEmployeeById(id);
    }

    @RequestMapping("/test")
    @ResponseBody
    public Employee test(int id) {
        return employeeService.test(id);
    }
}
