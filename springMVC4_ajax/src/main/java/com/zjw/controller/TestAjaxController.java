package com.zjw.controller;

import com.zjw.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
//@RestController==>@Controller+@ResponseBody
public class TestAjaxController {
    //@RequestBody将请求体中的数据和控制器方法的形参进行绑定
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id："+id);
        System.out.println("请求体："+requestBody);
        response.getWriter().write("hello,axios");
    }
    //使用@RequestBody注解将json格式的请求参数转化为Java对象
    /*1、导入jackson的依赖
    2、SpringMVC的配置文件中设置开启mvc的注解驱动
    3、在控制器方法的形参位置，设置json格式的请求参数要转换成的java类型（实体类或map）的参
    数，并使用@RequestBody注解标识*/
    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody1(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello,RequestBody");
    }
    //或者用map
    @RequestMapping("/test/RequestBody/json1")
    public void testRequestBody2(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello,RequestBody");
    }
    /*@ResponseBody响应浏览器json数据的条件：
    1、导入jackson的依赖
    2、SpringMVC的配置文件中设置开启mvc的注解驱动
    3、使用@ResponseBody注解标识控制器方法，在方法中，将需要转换为json字符串并响应到浏览器
    的java对象作为控制器方法的返回值，此时SpringMVC就可以将此对象直接转换为json字符串并响应到浏览器*/
    @RequestMapping("/test/ResponseBody")
    @ResponseBody//将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/SpringMVC/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBodyJson(){
        User user = new User(1001, "zjw", "123456", 20, "男");
        return user;
    }
}
