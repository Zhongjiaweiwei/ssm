package org.example;

import org.example.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByAnnotationTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext context=new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = context.getBean(Calculator.class);
        //calculator.add(2, 1);
        //calculator.div(2,0);
        calculator.mul(1,2);
    }
}
