package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DruidConnectionTest {
    @Test
    public void testConnection(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-jdbc.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
