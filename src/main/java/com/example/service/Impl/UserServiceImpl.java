package com.example.service.Impl;

import com.example.cache.RedisCache;
import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.redis.RedisCacheUtil;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Service
public class UserServiceImpl implements UserService {

    public static final String CACHE_NAME = "user";

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    private RedisCache redisCache;

    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @CacheEvict(value = "User", beforeInvocation=true, key = "'User' + #id")
    @Override
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    @Cacheable(value = "User",key = "'User' + #id")
    public User selectUserById(Integer id) {
        LOGGER.debug("id为{}",id);
        return userDao.selectUserById(id);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @CacheEvict(value = "User", key = "'User' + #user.getId()", beforeInvocation = true)
    public Integer addUser(User user) {
        LOGGER.debug("添加的用户id为{}",user.getId());
        redisCache.put("User" + user.getId(), user);
        return userDao.addUser(user);
    }
}
