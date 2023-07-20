package org.example;


import org.example.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByXmlTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext context=new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = context.getBean(Calculator.class);
        calculator.add(1,2);
    }
}
