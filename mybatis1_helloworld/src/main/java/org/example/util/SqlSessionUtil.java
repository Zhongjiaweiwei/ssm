package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试类每次都要调用sqlSession
 * 所以用统一的配置类简化代码
 */
public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        try {
            //获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory对象
            SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sql的绘画对象SqlSession，是Mybatis提供的操作数据库的对象
            //SqlSession sqlSession = sessionFactory.openSession();
            //SqlSession有带参构造方法,类型为boolean,当参数为true时自动提交事务
            sqlSession = sessionFactory.openSession(true);
        }catch (IOException e){
            e.printStackTrace();
        }
        return sqlSession;
    }
}
