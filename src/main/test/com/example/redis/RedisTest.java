package com.example.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lvxiao on 2018/9/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml", "/dispatcher-servlet.xml"})
public class RedisTest {
    @Autowired
    private RedisCacheUtil redisCache;

    private String key = "key1";
    private String field = "field1";
    private String value = "vaule1";

    @Before
    public void setup() {
        redisCache.hset(key, field, value);
    }
    @Test
    public void t1() {
        System.out.println("得到的数据: " + redisCache.hget(key, field));
    }
}
