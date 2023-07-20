package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.CacheMapper;
import org.example.pojo.Emp;
import org.example.util.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testCacheOne(){
        /*
        一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就
        会从缓存中直接获取，不会从数据库重新访问
        使一级缓存失效的四种情况：
        1) 不同的SqlSession对应不同的一级缓存
        2) 同一个SqlSession但是查询条件不同
        3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
        4) 同一个SqlSession两次查询期间手动清空了缓存
        */
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(7);//执行一次SQL，并存入缓存
        System.out.println(emp1);
        Emp emp2 = mapper1.getEmpById(7);
        System.out.println(emp2);//运行发现只执行过一次sql语句，实质上是从缓存中读取数据
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(7);//发现再次执行SQL，实质上是不同的SqlSession对应不同的一级缓存
        System.out.println(emp3);
    }
    @Test
    public void  testCacheTwo() throws IOException {
        /*
        二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；
        此后若再次执行相同的查询语句，结果就会从缓存中获取
        1、二级缓存开启的条件：
        a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
        b>在映射文件中设置标签<cache>
        c>二级缓存必须在SqlSession关闭或提交之后有效
        d>查询的数据所转换的实体类类型必须实现序列化的接口
        2、使二级缓存失效的情况：
        两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效*/
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(7);//第一次执行sql并存入缓存
        System.out.println(emp1);
        sqlSession1.close();//二级缓存必须在SqlSession关闭或提交之后有效
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(7);//发现只执行了一次sql，从缓存中直接拿取数据
        System.out.println(emp2);
        sqlSession2.close();
    }
}
