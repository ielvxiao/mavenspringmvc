package com.example.controller;

import com.example.domain.webservice.Departments;
import com.example.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lvxiao on 2018/9/7.
 */
@RequestMapping("/department")
@ResponseBody
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping("/select")
    @ResponseBody
    public Departments selectDepartmentById(String id) {
        return departmentsService.selectDepartmentById(id);
    }
}
