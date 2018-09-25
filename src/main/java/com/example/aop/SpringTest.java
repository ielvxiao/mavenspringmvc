package com.example.aop;

import com.example.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by lvxiao on 2018/9/18.
 */
@Aspect
@Component
public class SpringTest {
    @Pointcut(value = "execution(* *..UserService*.*(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut() && args(id)", argNames = "id")
    public void test(Integer id) {
        System.out.println("方法执行前执行了 id是 " + id);
    }

    @After("pointCut()")
    public void after() {
        System.out.println("方法执行后执行了~~~");
    }

    @Around("pointCut()")
    public User arround(ProceedingJoinPoint point) {
        System.out.println("arround前");
        User user = null;
        try {
            user = (User) point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("arround后");
        return user;
    }
}
