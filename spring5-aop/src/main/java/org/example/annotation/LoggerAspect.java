package org.example.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//定义切面组件，可以有切面方法
@Aspect
public class LoggerAspect {
    //切入表达式的重用
    @Pointcut("execution(* org.example.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    //前置通知(try...catch...finally中的try执行）
    //@Before("execution(public int org.example.annotation.CalculatorImpl.add(int ,int ))")
    @Before("execution(* org.example.annotation.CalculatorImpl.*(..))")
    public void beforeAdviceMethod(){
        System.out.println("前置通知");
    }

    //后置通知(try...catch...finally中的finally执行）
    //@After("execution(* org.example.annotation.CalculatorImpl.*(..))")
    @After("pointCut()")
    //JoinPoint获取连接点的信息，即定义的是什么方法，获取的就是那个方法的信息
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应的签名信息(声明信息)
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("方法名:"+signature.getName());
        System.out.println("属性:"+ Arrays.toString(args));
    }

    //返回通知(try...catch...finally中的try返回值输出之后执行）
    /*
    returning是设置返回值的名字的
    在返回值通知中若要获取目标对象方法的返回值
    只需要通过@AfterReturning注解的returning属性
    就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
    */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint,Object result){
        System.out.println("结果："+result);
    }

    //异常通知(try...catch...finally中的catch中执行）
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint,Throwable ex){
        System.out.println("异常："+ex);
    }

    //环绕通知(try...catch...finally中的try中围着目标方法执行）
    //ProceedingJoinPoint可以执行目标方法
    //特别注意：必须要有方法的返回值
    @Around(value = "pointCut()")
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
