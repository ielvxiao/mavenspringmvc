package com.example.cache;

import com.example.util.SerializableUtil;
import org.springframework.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * Created by tl on 17/2/28.
 */
public class RedisCache{

    /**
     * Redis
     */
    private static RedisTemplate redisTemplate;

    /**
     * 缓存名称
     */
    private static String name;

    /**
     * 超时时间
     */
    private static long timeout;


    /*
     * (non-Javadoc)
     * @see org.springframework.cache.Cache#getName()
     */
    public String getName() {
        return this.name;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.cache.Cache#getNativeCache()
     */
    public Object getNativeCache() {
        // TODO Auto-generated method stub
        return this.redisTemplate;
    }


    /*
     * (non-Javadoc)
     * @see org.springframework.cache.Cache#get(java.lang.Object)
     */
    public static Object get(Object key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        } else {
            final String finalKey;
            if (key instanceof String) {
                finalKey = (String) key;
            } else {
                finalKey = key.toString();
            }
            Object object = null;
            object = redisTemplate.execute(new RedisCallback<Object>() {
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    byte[] key = finalKey.getBytes();
                    byte[] value = connection.get(key);
                    if (value == null) {
                        return null;
                    }
                    return SerializableUtil.unserialize(value);
                }
            });
            return object;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.cache.Cache#get(java.lang.Object, java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(Object key, Class<T> type) {
        if (StringUtils.isEmpty(key) || null == type) {
            return null;
        } else {
            final String finalKey;
            final Class<T> finalType = type;
            if (key instanceof String) {
                finalKey = (String) key;
            } else {
                finalKey = key.toString();
            }
            final Object object = redisTemplate.execute(new RedisCallback<Object>() {
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    byte[] key = finalKey.getBytes();
                    byte[] value = connection.get(key);
                    if (value == null) {
                        return null;
                    }
                    return SerializableUtil.unserialize(value);
                }
            });
            if (finalType.isInstance(object)) {
                return (T) object;
            } else {
                return null;
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.cache.Cache#put(java.lang.Object, java.lang.Object)
     */
    public static boolean put(final Object key, final Object value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return false;
        } else {
            final String finalKey;
            if (key instanceof String) {
                finalKey = (String) key;
            } else {
                finalKey = key.toString();
            }
            if (!StringUtils.isEmpty(finalKey)) {
                final Object finalValue = value;
                return (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
                    @Override
                    public Boolean doInRedis(RedisConnection connection) {
                        connection.set(finalKey.getBytes(), SerializableUtil.serialize(finalValue));
                        // 设置超时间
                        connection.expire(finalKey.getBytes(), timeout);
                        return true;
                    }
                });
            }
        }
        return false;
    }

    public static void putIfAbsent(Object o, Object o1) {
        put(o, o1);
    }

    /*
     * 根据Key 删除缓存
     */
    public static Object evict(Object key) {
        Object o = null;
        if (null != key) {
            final String finalKey;
            if (key instanceof String) {
                finalKey = (String) key;
            } else {
                finalKey = key.toString();
            }
            if (!StringUtils.isEmpty(finalKey)) {
                o = redisTemplate.execute(new RedisCallback<Long>() {
                    public Long doInRedis(RedisConnection connection) throws DataAccessException {
                        return connection.del(finalKey.getBytes());
                    }
                });
            }
            return o;
        }
        return o;
    }

    /*
     * 清除系统缓存
     */
    public static void clear() {
         redisTemplate.execute(new RedisCallback<String>() {
         public String doInRedis(RedisConnection connection) throws DataAccessException {
         connection.flushDb();
         return "ok";
         }
         });
    }

    public static long size() {
        return (Long) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.dbSize();
            }
        });
    }

    public static RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
