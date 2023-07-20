package com.zjw.controller;

import com.zjw.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zjw.pojo.Employee;

import java.util.Collection;

/**
 * 要实现的功能
 * 功能                      URL地址        请求方式
 * 访问首页√                    /             GET
 * 查询全部数据√               /employee       GET
 * 删除√                   /employee/2      DELETE
 * 跳转到添加数据页面√          /to/add          GET
 * 执行保存√                /employee         POST
 * 跳转到更新数据页面√       /employee/2        GET
 * 执行更新√                /employee         PUT
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //获取所有员工信息
        Collection<Employee> employees = employeeDao.getAll();
        //将数据添加进入请求域中
        model.addAttribute("employees", employees);
        //跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        //重定向到列表功能
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id")Integer id,Model model){
        //根据id查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工共享到请求域中
        model.addAttribute("employee",employee);
        //跳转到更新页面
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String toUpdate(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
