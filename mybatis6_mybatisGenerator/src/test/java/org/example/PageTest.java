package org.example;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能开始前开启分页功能
        //pageNum：当前页的页码
        //pageSize：每页显示的条数
        PageHelper.startPage(1,4);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
    }
    @Test
    public void testPage2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能开始前开启分页功能
        Page<Object> page = PageHelper.startPage(5, 4);
        List<Emp> emps = mapper.selectByExample(null);
        //查询之后可以获取分页相关的所有数据
        //在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, int navigatePages)获取分页相关数据
        //list：分页之后的数据
        //navigatePages：导航分页的页码数
        PageInfo<Emp> pageInfo=new PageInfo<>(emps,5);
        emps.forEach(System.out::println);
        System.out.println(page);
        System.out.println(pageInfo);
        /*
        pageNum：当前页的页码
        pageSize：每页显示的条数
        size：当前页显示的真实条数
        total：总记录数
        pages：总页数
        prePage：上一页的页码
        nextPage：下一页的页码
        isFirstPage/isLastPage：是否为第一页/最后一页
        hasPreviousPage/hasNextPage：是否存在上一页/下一页
        navigatePages：导航分页的页码数
        navigatepageNums：导航分页的页码，[1,2,3,4,5]
         */
    }
}
