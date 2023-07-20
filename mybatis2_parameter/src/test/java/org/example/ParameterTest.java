package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    @Test
    public void testSelectByName1(){
        User user = mapper.selectUserByName1("root");
        System.out.println(user);
    }
    @Test
    public void testSelectByName2(){
        User user = mapper.selectUserByName2("root");
        System.out.println(user);
    }
    @Test
    public void testLogin(){
        User user = mapper.checkLogin("root", "123456");
        System.out.println(user);
    }
    @Test
    public void testLoginByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","root");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsert(){
        User user = new User(null, "root", "123456", 33, "男", "123456@qq.com");
        mapper.insertUser(user);
    }
    @Test
    public void testLoginByParam(){
        User user = mapper.checkLoginByParam("root", "123456");
        System.out.println(user);
    }
}
