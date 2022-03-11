package com.luobin.test;

import com.luobin.mapper.BrandMapper;
import com.luobin.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Doraemon
 * @date 2022/3/6 7:14 下午
 * @version 1.0
 */
public class MybatisBrandTest {
    @Test
    public static void main(String[] args) throws IOException {
        // 1 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 获取 mapper 接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);

        // 5 释放资源
        sqlSession.close();
    }
}
