package com.zjw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.zjw.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Test2_ParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名："+username+"   密码："+password);
        return "success";
    }
    //当网页输入的参数和设置的形参的名字相同时，会自动进行绑定
    @RequestMapping("/param1")
    public String getParam1(String username,String password){
        System.out.println("用户名："+username+"   密码："+password);
        return "success";
    }
    //当网页输入的参数和设置的形参的名字不相同时，设置@RequestParam与形参进行绑定
    //required默认为true，意思就是必须传输该注解标识的参数
    //defaultValue为如果没有传入参数，则会默认赋值一个参数，和required没有关系
    @RequestMapping("/param2")
    public String getParam2(@RequestParam(value = "Username",required = true) String username,
           @RequestParam(value = "Password",defaultValue = "123456") String password){
        System.out.println("用户名："+username+"   密码："+password);
        return "success";
    }
    /*@RequestHeader是将请求头信息和控制器方法的形参创建映射关系*/
    @RequestMapping("/param3")
    public String getParam3(String username,String password,@RequestHeader("referer") String referer){
        System.out.println("用户名："+username+"   密码："+password+"   请求头信息"+referer);
        return "success";
    }
    /*@CookieValue是将cookie数据和控制器方法的形参创建映射关系*/
    //先获取cookie
    @RequestMapping("/param/servletAPI1")
    public String getParamServletAPI1(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名："+username+"   密码："+password);
        return "success";
    }
    @RequestMapping("/param4")
    public String getParam4(String username,String password,@CookieValue("JSESSIONID") String jsessionId){

        System.out.println("用户名："+username+"   密码："+password+"   cookie数据："+jsessionId);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
    /*解决请求方式乱码问题：
    get:8.0版本之前tomcat在Tomcat配置文件中配置即可解决乱码，8.0版本之后tomcat默认解决乱码
    post:无论什么版本都要在控制器中添加过滤器解决乱码*/
}
