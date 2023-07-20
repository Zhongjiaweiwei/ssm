package org.example.factory;

import org.example.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {
    //通过一个对象交给IOC容器管理
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    //设置所提供的对象
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
