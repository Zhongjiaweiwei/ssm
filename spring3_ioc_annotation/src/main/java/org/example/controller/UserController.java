package org.example.controller;

import org.example.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    /*
    1、@Autowired 按类型自动装配
    2、@Qualifier 按名称进行装配,与@Autowired搭配使用
    3、@Resource 可以先按名称再按类型自动进行装配，如果指定了名称，只能按名称进行装配，是J2EE规范，
    @Autowired和@Qualifier 是spring规范。
    */
    @Resource//该注解可添加在赋值方法里（即成员变量、构造方法、set方法）
    private UserService userService;

    public void saveUser() {
        userService.saveUser();
    }
}
