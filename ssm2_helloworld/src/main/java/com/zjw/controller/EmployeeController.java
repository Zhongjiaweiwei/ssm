package com.zjw.controller;

import com.github.pagehelper.PageInfo;
import com.zjw.pojo.Employee;
import com.zjw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 获取员工的分页信息
     */
    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeeList(@PathVariable("pageNum") Integer pageNum,Model model){
        PageInfo<Employee> page=employeeService.getEmployeeList(pageNum);
        model.addAttribute("page",page);
        return "employee_list";
    }
}
