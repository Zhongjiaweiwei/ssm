package org.example;

import org.example.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    @Test
    public void testIOCByAnnotation1(){
        /*
        @Component：将类标识为普通组件
        @Controller：将类标识为控制层组件
        @Service：将类标识为业务层组件
        @Repository：将类标识为持久层组件
        */
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = context.getBean(UserController.class);
        userController.saveUser();
    }
    @Test
    public void testIOCByAnnotation2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.saveUser();
    }
}
