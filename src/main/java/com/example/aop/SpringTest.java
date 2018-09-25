package com.example.aop;

/**
 * Created by lvxiao on 2018/9/18.
 */
public class SpringTest {
    public void doBefore() {
        System.out.println("方法执行前执行了");
    }

    public void doAfter() {
        System.out.println("方法执行后执行了");
    }
}
