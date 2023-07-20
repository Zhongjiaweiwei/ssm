package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.pojo.EmpExample;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class MbgTest {
    @Test
    public void testSelectByPrimary(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据id查数据
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);
    }
    @Test
    public void testSelectByExample1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询所有数据
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
    }
    @Test
    public void testSelectByExample2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample empExample = new EmpExample();
        //创建一个条件对象，后面接条件
        empExample.createCriteria().andEmpNameEqualTo("钟佳炜").andAgeBetween(10,25);
        //如果还想要添加条件
        empExample.or().andGenderEqualTo("男");
        List<Emp> emps = mapper.selectByExample(empExample);
        emps.forEach(System.out::println);
    }
    @Test
    public void testUpdateByPrimary(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据ID修改数据,这里的null会将值修改为null
        Emp emp = new Emp(1, "张三", 22, null, 2);
        mapper.updateByPrimaryKey(emp);
    }
    @Test
    public void testUpdateByPrimarySelective(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据ID选择性修改数据，这里的null并不会做修改
        Emp emp = new Emp(1, "张三", 22, null , 2);
        mapper.updateByPrimaryKeySelective(emp);
    }
}
