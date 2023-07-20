package org.example.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)//设置优先值，值越小，优先级越高，默认值为Integer的最大值
public class ValidateAspect {

    //pointCut可以引用其他类的
    @Before(value = "org.example.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }
}
