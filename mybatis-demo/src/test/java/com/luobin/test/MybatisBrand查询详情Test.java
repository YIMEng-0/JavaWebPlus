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
 * @date 2022/3/8 11:28 上午
 * @version 1.0
 */
public class MybatisBrand查询详情Test {
    @Test
    public static void main(String[] args) throws IOException {
        int id = 1;

        // 1 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 获取 mapper 接口的代理对象
        BrandMapper brandMapper =  sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        // 返回来的是一个 所以不需要使用列表进行数据的接收
        Brand brands = brandMapper.selectById(id);

        System.out.println(brands);

        // 5 释放资源
        sqlSession.close();
    }
}
