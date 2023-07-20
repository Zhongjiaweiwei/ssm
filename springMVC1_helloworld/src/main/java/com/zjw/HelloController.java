package com.zjw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    /**
     * 添加首页入口
     */
    //该斜线代表路径的上下文为localhost:8080/SpringMVC
    @RequestMapping("/")
    public String portal(){
        return "index";
    }
    @RequestMapping("/hello")
    public String success(){
        return "success";
    }
}
