package com.zjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 对学生表进行rest操作
 * 查询所有的用户信息-->/user-->get
 * 根据id查询用户信息-->/user/1-->get
 * 添加用户信息-->/user-->post
 * 修改用户信息-->/user-->put
 * 查删除用户信息-->/user/1-->delete
 */
@Controller
public class TestRestController {
    //@GetMapping
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息");
        return "success";
    }
    //@GetMapping
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id")Integer id){
        System.out.println("根据id查询用户信息");
        return "success";
    }
    //@PostMapping
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(){
        System.out.println("添加用户信息");
        return "success";
    }
    //@PutMapping
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息");
        return "success";
    }
    //@DeleteMapping
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id")Integer id){
        System.out.println("根据id删除用户信息");
        return "success";
    }
}
