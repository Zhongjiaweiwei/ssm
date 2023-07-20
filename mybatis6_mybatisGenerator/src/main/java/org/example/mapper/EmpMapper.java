package org.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Emp;
import org.example.pojo.EmpExample;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据条件获取总记录数
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int countByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据条件删除
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int deleteByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据条件删除
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int deleteByPrimaryKey(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 添加emp
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 选择性添加，与上面的方法对比，上面的方法添加若无条件会设置为null
     * 而该方法会设置为数据库表已经设置的默认值
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int insertSelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据条件查询
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    List<Emp> selectByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据主键查询
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    Emp selectByPrimaryKey(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据条件选择性修改
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据条件普通修改
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据主键选择性修改
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int updateByPrimaryKeySelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * 根据主键修改
     * @mbggenerated Fri Mar 10 20:31:32 CST 2023
     */
    int updateByPrimaryKey(Emp record);
}