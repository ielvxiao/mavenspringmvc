package com.example.redis;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

/**
 * Created by lvxiao on 2018/9/28.
 */
@Caching(put = {
        @CachePut(value = "User", key = "'user_id_'+#user.id"),
        @CachePut(value = "User", key = "'user_username_'+#user.username"),
        @CachePut(value = "User", key = "'user_email_'+#user.email")
})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UserSaveCache {
}
