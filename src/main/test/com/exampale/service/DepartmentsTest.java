package com.exampale.service;

import com.example.service.DepartmentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lvxiao on 2018/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml", "/dispatcher-servlet.xml"})
public class DepartmentsTest {

    private MockMvc mockMvc;

    @Autowired
    private DepartmentsService departmentsService;

    @Test
    public void selectDepartmentById() {
        try {
            mockMvc.perform(get("/department/select")
            .param("id", "d001"))
            .andExpect(status().is(200))
            .andExpect(content().string("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(departmentsService.selectDepartmentById("d001"));
    }
}
