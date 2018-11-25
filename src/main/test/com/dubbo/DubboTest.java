package com.dubbo;

import com.example.service.DubboTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author lvxiao
 * Date 2018-11-25 00:53
 * TODO: 描述信息
 * Version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/dubbo_consumer.xml")
public class DubboTest {

    @Resource
    private DubboTestService dubboTestService;
    @Test
    public void test() {
        dubboTestService.sayHello("hello");
    }
}
