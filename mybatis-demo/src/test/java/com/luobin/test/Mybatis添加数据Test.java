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
public class Mybatis添加数据Test {
    @Test
    public static void main(String[] args) throws IOException {
        Brand brand = new Brand();
        brand.setBrandName("电器");
        brand.setCompanyName("京东");
        brand.setStatus(1);
        brand.setDescription("狗洞");

        // 1 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 获取 mapper 接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        brandMapper.add(brand);

        // 提交事务 否则数据库中没有记录的存储的
        sqlSession.commit();

        System.out.println(brand.getId());

        // 5 释放资源
        sqlSession.close();
    }
}
