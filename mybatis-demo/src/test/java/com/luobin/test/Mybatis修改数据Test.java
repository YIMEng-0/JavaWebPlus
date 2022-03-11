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

/**
 * @author Doraemon
 * @date 2022/3/6 7:14 下午
 * @version 1.0
 */
public class Mybatis修改数据Test {
    @Test
    public static void main(String[] args) throws IOException {
        Brand brand = new Brand();
        brand.setBrandName("电器1 动态修改的结果");
//        brand.setCompanyName("京东1");
//        brand.setStatus(1);
//        brand.setDescription("狗洞1");
//        brand.setOrdered(10);
        brand.setId(5);

        // 1 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 获取 mapper 接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        int count = brandMapper.update(brand);

        // 提交事务 否则数据库中没有记录的存储的
        sqlSession.commit();

        System.out.println("变化的行数是：" + count);

        // 5 释放资源
        sqlSession.close();
    }
}
