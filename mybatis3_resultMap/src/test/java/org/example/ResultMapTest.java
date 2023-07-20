package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.DeptMapper;
import org.example.mapper.EmpMapper;
import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

public class ResultMapTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    @Test
    public void testGetEmpById1(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById1(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpById2(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById2(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpById3(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById3(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptById1(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptById1(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptById2(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptById2(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptById3(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptById3_1(1);
        System.out.println(emp);
    }
    @Test
    public void testGetDeptAndEmpById1(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId1(1);
        System.out.println(dept);
    }
    @Test
    public void testGetDeptAndEmpById2(){
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId2_1(1);
        System.out.println(dept);
    }
}
