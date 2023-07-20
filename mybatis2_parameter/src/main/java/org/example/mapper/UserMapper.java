package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 通过属性名查找user
     * @param username
     * @return
     */
    User selectUserByName1(String username);
    /**
     * 通过属性名查找user
     * @param username
     * @return
     */
    User selectUserByName2(String username);

    /**
     * 通过属性名和密码查找user
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 通过添加map集合，map集合再添加user属性对user进行查询
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 插入一条user记录
     * @param user
     */
    void insertUser(User user);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username")String username,@Param("password")String password);



}
