package com.zjw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class Test3_ScopeController {
    /*域对象共享数据共有五种方式
    1、使用ServletAPI向request域对象共享数据*/
    @RequestMapping("/test/servletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testServletAPIScope","hello,servletAPI-->使用ServletAPI向request域对象共享数据");
        return "success";
    }
    //2、使用ModelAndView向request域对象共享数据
    @RequestMapping("/test/mav")
    public ModelAndView testModelAndView(){
        //实例化
        ModelAndView modelAndView = new ModelAndView();
        //model:向请求域中共享数据
        modelAndView.addObject("testModelAndViewScope","hello,modelAndView-->使用ModelAndView向request域对象共享数据");
        //view:设置逻辑视图实现页面跳转
        modelAndView.setViewName("success");
        return modelAndView;
    }
    //3、使用Model向request域对象共享数据
    @RequestMapping("/test/model")
    public String testModel(Model model){
        //model:向请求域中共享数据
        model.addAttribute("testModelScope","hello,model-->使用Model向request域对象共享数据");
        return "success";
    }
    //4、使用map向request域对象共享数据
    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        map.put("testMapScope","hello,map-->使用map向request域对象共享数据");
        return "success";
    }
    //5、使用ModelMap向request域对象共享数据
    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testModelMapScope","hello,modelMap-->使用ModelMap向request域对象共享数据");
        return "success";
    }
    //使用ServletAPI向session域共享数据
    //session：一次会话，浏览器开启到浏览器关闭的过程
    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session-->使用ServletAPI向session域共享数据");
        return "success";
    }
    //使用ServletAPI向application域共享数据
    //application：服务器整个运行过程中
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello,application-->使用ServletAPI向application域共享数据");
        return "success";
    }
}
