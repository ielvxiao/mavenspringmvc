package com.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by lvxiao on 2018/9/18.
 */
@Aspect
@Component
public class SpringTest {
    @Pointcut(value = "execution(* *..UserService*.*(..))")
    public void doBefore() {

    }

    @Before("doBefore()")
    public void test() {
        System.out.println("方法执行前执行了");
    }
}
