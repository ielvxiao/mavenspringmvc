package com.example.cache;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Created by lvxiao on 2018/9/11.
 */
public class RedisCacheTransfer {
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
