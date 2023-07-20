package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;

public interface SpecialMapper {
    /**
     * 根据名字模糊查询返回user列表
     * 第一种方式
     * @param username
     * @return
     */
    List<User> getUserByDimName1(@Param("username") String username);
    /**
     * 根据名字模糊查询返回user列表
     * 第二种方式
     * @param username
     * @return
     */
    List<User> getUserByDimName2(@Param("username") String username);
    /**
     * 根据名字模糊查询返回user列表
     * 第三种方式
     * @param username
     * @return
     */
    List<User> getUserByDimName3(@Param("username") String username);

    /**
     * 批量删除id为......的user
     * @param ids
     */
    void deleteMoreUser(@Param("ids")String ids);

    /**
     * 动态设置表名，查询所有用户信息
     * @param tableName
     * @return
     */
    List<User> getAllUser(@Param("tableName")String tableName);

    /**
     * 添加用户信息并获取自增的主键
     * @param user
     */
    void insertUser(User user);
}
