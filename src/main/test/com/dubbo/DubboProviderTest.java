package com.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

/**
 * Author lvxiao
 * Date 2018-11-25 21:34
 * Description: TODO
 * Version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/dubbo_provider.xml")
public class DubboProviderTest {
    @Test
    public void test() {
        try {
            new CountDownLatch(1).await(); //hold住应用，防止provider退出
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
