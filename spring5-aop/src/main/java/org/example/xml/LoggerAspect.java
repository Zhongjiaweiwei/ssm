package org.example.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {

    public void beforeAdviceMethod(){
        System.out.println("前置通知");
    }

    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应的签名信息(声明信息)
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("方法名:"+signature.getName());
        System.out.println("属性:"+ Arrays.toString(args));
    }

    public void afterReturningAdvice(JoinPoint joinPoint,Object result){
        System.out.println("结果："+result);
    }

    public void afterThrowingAdvice(JoinPoint joinPoint,Throwable ex){
        System.out.println("异常："+ex);
    }

    public Object AroundAdvice(ProceedingJoinPoint joinPoint){
        Object result=null;
        try {
            System.out.println("环绕通知-->前置通知");
            //执行目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        }finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}
