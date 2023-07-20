package org.example;

import org.example.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByXmlTest {
    @Test
    public void testAutowireByXml(){
        ApplicationContext context=new ClassPathXmlApplicationContext("autowire-xml.xml");
        UserController controller = context.getBean(UserController.class);
        controller.saveUser();
    }
}
