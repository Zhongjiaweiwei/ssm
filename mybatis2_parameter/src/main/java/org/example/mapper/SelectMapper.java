package org.example.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询user
     * @param id
     * @return
     */
    User getUserById(@Param("id")Integer id);

    /**
     * 查询所有学生信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询user的总记录数
     * @return
     */
    Integer getUserCount();

    /**
     * 通过id返回一个map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     * 查询所有user对象添加进map集合中,map再添加进list中，最终以list输出map中的键值对
     * @return
     */
    //这里返回的有四个对象，而map只能存储一个object对象
    //Map<String,Object> getAllUserToMap();
    //所以改成list集合存储四个对象
    List<Map<String,Object>> getAllUserToMap1();

    /**
     * 查询所有user对象添加进map集合中
     * @return
     */
    //当然，都能用list存储map，那肯定也能用map存储map
    //此处以id为键
    @MapKey("id")
    Map<String,Object> getAllUserToMap2();
}
