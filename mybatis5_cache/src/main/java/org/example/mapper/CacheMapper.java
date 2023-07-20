package org.example.mapper;


import org.apache.ibatis.annotations.Param;
import org.example.pojo.Emp;

public interface CacheMapper {
    Emp getEmpById(@Param("empId") Integer empId);
}
