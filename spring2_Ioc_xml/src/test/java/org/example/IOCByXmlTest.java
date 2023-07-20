package org.example;

import org.example.pojo.Clazz;
import org.example.pojo.Person;
import org.example.pojo.Student;
import org.example.pojo.Student1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXmlTest {
    @Test
    public void testIOC1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //注意：需要实体类设置无参构造方法
        Student studentOne = context.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }
    @Test
    public void testIOC2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean的三种方式
        //1、根据id获取
        Student student1 = (Student) context.getBean("Student");
        //2、根据类型获取
        //当根据类型获取bean时，要求IOC容器中指定类型的bean有且只能有一个
        //<bean id="helloworldOne" class="com.atguigu.spring.bean.HelloWorld"></bean>
        //<bean id="helloworldTwo" class="com.atguigu.spring.bean.HelloWorld"></bean>
        //上面这两个同时存在就会报错
        Student student2 = context.getBean(Student.class);
        //根据id和类型
        Student student3 = context.getBean("studentOne", Student.class);
    }
    @Test
    public void testIOC3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //组件类实现了接口，根据接口类型可以获取 bean(向上赋值)
        Person student = context.getBean("studentOne", Student.class);
        Person person = context.getBean(Person.class);
        //如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型不可以获取 bean
        //结论：根据类型来获取bean时，在满足bean唯一性的前提下，
        // 其实只是看：『对象 instanceof 指定的类型』的返回结果，
        // 只要返回的是true就可以认定为和类型匹配，能够获取到。
        //即通过bean的类型，bean所继承的类的类型，bean所实现的接口的类型都可以获取bean
    }
    @Test
    public void testDI1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean("studentTwo", Student.class);
        System.out.println(student);
    }
    @Test
    public void testDI2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean("studentThree", Student.class);
        System.out.println(student);
    }
    @Test
    public void testDI3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean("studentFour", Student.class);
        System.out.println(student);
    }
    @Test
    public void testDI4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean("studentFive", Student.class);
        System.out.println(student);
    }
    //引用方式注入
    @Test
    public void testDI5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student1 student = context.getBean("studentSix", Student1.class);
        System.out.println(student);
    }
    //级联方式注入
    @Test
    public void testDI6(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student1 student = context.getBean("studentSeven", Student1.class);
        System.out.println(student);
    }
    //内部类方式注入
    @Test
    public void testDI7(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student1 student = context.getBean("studentEight", Student1.class);
        System.out.println(student);
    }
    //为数组赋值
    @Test
    public void testDI8(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student1 student = context.getBean("studentNine", Student1.class);
        System.out.println(student);
    }
    //为集合赋值
    @Test
    public void testDI9(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = context.getBean("clazz", Clazz.class);
        System.out.println(clazz);
    }
    //为map赋值方式1
    @Test
    public void testDI10(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student1 student = context.getBean("studentTen", Student1.class);
        System.out.println(student);
    }
    //为map赋值方式2
    @Test
    public void testDI11(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student1 student = context.getBean("studentEleven", Student1.class);
        System.out.println(student);
    }
    //为map赋值方式3
    @Test
    public void testDI12(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student1 student = context.getBean("studentTwelve", Student1.class);
        System.out.println(student);
    }
}
