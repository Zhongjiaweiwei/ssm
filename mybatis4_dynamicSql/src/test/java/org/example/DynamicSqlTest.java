package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.DynamicSqlMapper;
import org.example.pojo.Emp;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSqlTest {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    @Test
    public void testGetEmpByIf(){
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> emps = mapper.getEmpByCondition1(new Emp(null, "张三", 20, "男"));
        emps.forEach(System.out::println);
    }
    @Test
    public void testGetEmpByWhere(){
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> emps = mapper.getEmpByCondition2(new Emp(null, "张三", 20, "男"));
        emps.forEach(System.out::println);
    }
    @Test
    public void testGetEmpByChoose(){
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> emps = mapper.getEmpByChoose(new Emp(null, "张三", 20, "男"));
        emps.forEach(System.out::println);
    }
    @Test
    public void insertMoreEmp(){
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp1 = new Emp(null, "张三", 20, "男");
        Emp emp2 = new Emp(null, "李四", 20, "男");
        Emp emp3 = new Emp(null, "王五", 20, "男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(emps);
    }
    @Test
    public void deleteEmp1(){
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] ints=new Integer[]{1,2};
        mapper.deleteMoreEmp1(ints);
    }
    @Test
    public void deleteEmp2(){
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] ints=new Integer[]{3,4};
        mapper.deleteMoreEmp2(ints);
    }
    @Test
    public void deleteEmp3(){
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Integer[] ints=new Integer[]{5,6};
        mapper.deleteMoreEmp2(ints);
    }
}
