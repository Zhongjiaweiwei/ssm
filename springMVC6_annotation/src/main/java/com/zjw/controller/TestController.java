package com.zjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test/hello")
    public String sayHello(){
        int i=1/0;
        return "success";
    }
}
