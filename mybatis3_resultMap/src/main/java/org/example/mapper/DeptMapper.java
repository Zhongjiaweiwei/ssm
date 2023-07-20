package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Dept;
import org.example.pojo.Emp;

public interface DeptMapper {
    /**
     * 根据id返回emp以及dept对象信息
     * 第三种方式（分布查询的第二步）
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptById3_2(@Param("deptId")Integer deptId);

    /**
     * 查询部门以及部门中的员工信息(collection方式)
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId1(@Param("deptId")Integer deptId);

    /**
     * 查询部门以及部门中的员工信息(分步查询方式)
     * 第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId2_1(@Param("deptId")Integer deptId);
}
