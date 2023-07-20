package org.example;

import org.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//设置当前测试类在spring的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate1(){
        String sql="insert into t_user values(1001,'root','123456',23,'男','123456@qq.com')";
        //该update可支持增删改功能
        int i = jdbcTemplate.update(sql);
        System.out.println(i);
    }
    @Test
    public void testUpdate2(){
        //也可以添加参数
        String sql="insert into t_user values(?,?,?,?,?,?)";
        //该update可支持增删改功能
        int i = jdbcTemplate.update(sql,1003,"root","123456",23,"男","123456@qq.com");
        System.out.println(i);
    }
    @Test
    public void testSelectUserById(){
        String sql="select * from t_user where id=?";
        //BeanPropertyRowMapper:实体属性映射
        //queryForObject(String sql,RowMapper<T> rowMapper,Object... args)//映射为某一条对象
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1001);
        System.out.println(user);
    }
    @Test
    public void testSelectAllUser(){
        String sql="select * from t_user";
        //query(String sql,RowMapper<T> rowMapper,Object... args)//映射为某一集合对象，返回值为list
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectUserCount(){
        String sql="select count(*) from t_user";
        //返回类型可以自定义
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
