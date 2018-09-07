package com.exampale.service;

import com.example.service.DepartmentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lvxiao on 2018/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml", "/dispatcher-servlet.xml"})
public class DepartmentsTest {

    @Autowired
    private DepartmentsService departmentsService;

    @Test
    public void selectDepartmentById() {
        System.out.println(departmentsService.selectDepartmentById("d001"));
    }
}
