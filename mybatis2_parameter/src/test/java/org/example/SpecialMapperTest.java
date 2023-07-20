package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.SpecialMapper;
import org.example.pojo.User;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class SpecialMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    SpecialMapper mapper = sqlSession.getMapper(SpecialMapper.class);

    @Test
    public void testGetUserByDimName1(){
        List<User> users = mapper.getUserByDimName1("o");
        users.forEach(System.out::println);
    }
    @Test
    public void testGetUserByDimName2(){
        List<User> users = mapper.getUserByDimName2("o");
        users.forEach(System.out::println);
    }
    @Test
    public void testGetUserByDimName3(){
        List<User> users = mapper.getUserByDimName3("o");
        users.forEach(System.out::println);
    }
    @Test
    public void testDeleteUserMore(){
        mapper.deleteMoreUser("1004,1005");
    }
    @Test
    public void testGetAllUser(){
        List<User> t_user = mapper.getAllUser("t_user");
        t_user.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        User user = new User(null, "root", "123456", 23, "男", "123456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
