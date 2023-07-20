package com.zjw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class Test1_RequestMappingController {
    @RequestMapping(value = {"/hello","/world"},method = RequestMethod.GET)
    public String hello(){
        return "success";
    }

    /*处理get请求的映射-->@GetMapping
    处理post请求的映射-->@PostMapping
    处理put请求的映射-->@PutMapping
    处理delete请求的映射-->@DeleteMapping*/
    /*@RequestMapping(value = "/success",method = RequestMethod.POST)*/
    @PostMapping("/success")
    public String postSuccess(){
        return "success";
    }

    /*"param"：要求请求映射所匹配的请求必须携带param请求参数
    "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
    "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
    "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value*/
    @RequestMapping(value = "/params",params = {"username","!password","age=20","gender!=男"})
    public String testParam(){
        return "success";
    }
    /*"header"：要求请求映射所匹配的请求必须携带header请求头信息
    "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
    "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
    "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value*/
    @RequestMapping(value = "/params1",headers = {"referer"})
    public String testParam1(){
        return "success";
    }

    /*SpringMVC支持ant风格的路径
    ？：表示任意的单个字符(不包括?)
    *：表示任意的0个或多个字符(不包括?和/)
    **：表示任意层数的任意目录
    注意：在使用**时，只能使用双斜线的方式*/
    @RequestMapping("/a?a/ant1")
    public String testAnt1(){
        return "success";
    }
    @RequestMapping("/a*a/ant2")
    public String testAnt2(){
        return "success";
    }
    @RequestMapping("/**/ant3")
    public String testAnt3(){
        return "success";
    }

    //@PathVariable:路径变量
    @RequestMapping("/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("获取id："+id);
        return "success";
    }
}
