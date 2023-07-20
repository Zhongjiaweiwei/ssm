package org.example.dao;
//dao是data access object ，即数据访问层，是直接和数据库打交道
// 直接操作数据库的，dao是和Xml一伙的，dao里面的方法在xml有对应的sql语句，sql语句的id就是dao里面的方法名；
public interface UserDao {
    void saveUser();
}
