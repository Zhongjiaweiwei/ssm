package org.example.service.Impl;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
