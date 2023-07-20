package org.example;

import org.example.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    @Test
    public void testLifeCycle1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("lifecycle.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
    @Test
    public void testLifeCycle2(){
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("lifecycle.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
        context.close();//为什么这里执行以后没有销毁方法，因为已经设置了多例模型，已经不由IOC管理
    }
}
