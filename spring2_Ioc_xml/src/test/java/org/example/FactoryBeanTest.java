package org.example;

import org.example.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
    @Test
    public void testFactoryBean(){
        ApplicationContext context=new ClassPathXmlApplicationContext("factory.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
