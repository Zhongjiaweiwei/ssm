package com.zjw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test4_ViewController {


    /*当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置
        的视图解析器解析，视图名称拼接视图前缀和视图*/
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){
        return "success";
    }


    /*当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，此时的视
    图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，剩余部
            分作为最终路径通过转发的方式实现跳转*/
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        return "forward:/test/hello";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        return "redirect:/test/hello";
    }
}
