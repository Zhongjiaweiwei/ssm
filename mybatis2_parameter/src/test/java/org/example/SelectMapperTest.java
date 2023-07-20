package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.SelectMapper;
import org.example.pojo.User;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

    @Test
    public void testGetUserById(){
        User user = mapper.getUserById(1002);
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        List<User> users = mapper.getAllUser();
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testGetUserCount(){
        Integer userCount = mapper.getUserCount();
        System.out.println(userCount);
    }
    @Test
    public void testGetUserByIdToMap(){
        Map<String, Object> map = mapper.getUserByIdToMap(1002);
        System.out.println(map);
    }
    @Test
    public void testGetAllUserToMap1(){
        List<Map<String, Object>> list = mapper.getAllUserToMap1();
        for (Map<String,Object> map:list){
            System.out.println(map);
        }
    }
    @Test
    public void testGetAllUserToMap2(){
        Map<String, Object> map = mapper.getAllUserToMap2();
        System.out.println(map);
    }
}
