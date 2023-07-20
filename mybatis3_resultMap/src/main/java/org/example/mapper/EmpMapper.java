package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Dept;
import org.example.pojo.Emp;

public interface EmpMapper {
    /**
     * 根据id返回emp对象信息
     * 第一种方式
     * @param empId
     * @return
     */
    Emp getEmpById1(@Param("empId")Integer empId);
    /**
     * 根据id返回emp对象信息
     * 第二种方式
     * @param empId
     * @return
     */
    Emp getEmpById2(@Param("empId")Integer empId);
    /**
     * 根据id返回emp对象信息
     * 第三种方式
     * @param empId
     * @return
     */
    Emp getEmpById3(@Param("empId")Integer empId);

    /**
     * 根据id返回emp以及dept对象信息
     * 第一种方式（级联方式）
     * @param empId
     * @return
     */
    Emp getEmpAndDeptById1(@Param("empId")Integer empId);
    /**
     * 根据id返回emp以及dept对象信息
     * 第二种方式（association)
     * @param empId
     * @return
     */
    Emp getEmpAndDeptById2(@Param("empId")Integer empId);
    /**
     * 根据id返回emp以及dept对象信息
     * 第三种方式（分布查询的第一步）
     * @param empId
     * @return
     */
    Emp getEmpAndDeptById3_1(@Param("empId")Integer empId);
    /**
     * 查询部门以及部门中的员工信息(分步查询方式)
     * 第二步
     * @param deptId
     * @return
     */
    Emp getDeptAndEmpByDeptId2_2(@Param("deptId")Integer deptId);
}
