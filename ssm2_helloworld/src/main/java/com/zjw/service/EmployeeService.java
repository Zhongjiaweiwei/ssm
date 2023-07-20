package com.zjw.service;

import com.github.pagehelper.PageInfo;
import com.zjw.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    PageInfo<Employee> getEmployeeList(Integer pageNum);
}
