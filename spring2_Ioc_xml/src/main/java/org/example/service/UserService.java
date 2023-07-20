package org.example.service;
//service是和serviceImpl一伙的，是一个处理流程，是一个业务逻辑，
//在处理业务的时候可能会用到数据库里面的数据，这时就需要调用dao里面的方法，其实就是执行sql语句了
public interface UserService {
    void saveUser();
}
