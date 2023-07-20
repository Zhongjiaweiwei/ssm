package org.example.mapper;

import org.example.pojo.User;

import java.util.List;

public interface UserMapper {
    //添加用户信息
    int insertUser();
    //修改用户信息
    int updateUser();
    //删除用户信息
    void deleteUser();
    //查询用户信息
    User selectUserById();
    //查询所有用户信息
    List<User> selectAllUser();
}
