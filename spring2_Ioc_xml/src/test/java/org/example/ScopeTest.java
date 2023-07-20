package org.example;

import org.example.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void testScope1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("scope.xml");
        Student student1 = context.getBean("student1", Student.class);
        Student student2 = context.getBean("student1", Student.class);
        System.out.println(student1==student2);//true
    }
    @Test
    public void testScope2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("scope.xml");
        Student student1 = context.getBean("student2", Student.class);
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student1==student2);//false
    }
}
