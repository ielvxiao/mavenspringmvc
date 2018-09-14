package com.example.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lvxiao on 2018/9/11.
 */
public class MybatisRedisCache implements Cache {

    private static JedisConnectionFactory jedisConnectionFactory;

    private final String id;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public void clear() {
        RedisCache.clear();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Object getObject(Object key) {
        return RedisCache.get(key);
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    @Override
    public int getSize() {

        return (int) RedisCache.size();
    }

    @Override
    public void putObject(Object key, Object value) {
        RedisCache.put(key, value);
    }

    @Override
    public Object removeObject(Object key) {
        return RedisCache.evict(key);
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        MybatisRedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }

}
