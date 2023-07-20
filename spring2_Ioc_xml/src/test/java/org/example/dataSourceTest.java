package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class dataSourceTest {
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("dataSource.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
