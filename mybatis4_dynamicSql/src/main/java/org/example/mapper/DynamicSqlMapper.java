package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Emp;

import java.util.List;

public interface DynamicSqlMapper {
    /**
     * 运用if标签
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition1(Emp emp);
    /**
     * 改进：运用if标签+where标签
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition2(Emp emp);
    /**
     * 改进：运用if标签+trim标签
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition3(Emp emp);

    /**
     * 使用choose查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量添加员工信息
     * @param emps
     */
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    /**
     * 批量删除
     * 第一种写法
     * @param empIds
     */
    void deleteMoreEmp1(@Param("empIds") Integer[] empIds);

    /**
     * 批量删除
     * 第二种写法
     * @param empIds
     */
    void deleteMoreEmp2(@Param("empIds") Integer[] empIds);
    /**
     * 批量删除
     * 第三种写法
     * @param empIds
     */
    void deleteMoreEmp3(@Param("empIds") Integer[] empIds);
}
