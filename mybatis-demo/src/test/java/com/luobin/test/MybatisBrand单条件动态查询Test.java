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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Doraemon
 * @date 2022/3/8 11:28 上午
 * @version 1.0
 */
public class MybatisBrand单条件动态查询Test {
    @Test
    public static void main(String[] args) throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数 模糊查询的时候需要使用 %% 或者下划线的占位符来对参数进行处理
        companyName = "%"+ companyName + "%"; // 因为使用模糊查询所以在这里使用百分号
        brandName = "%"+ brandName + "%";     // 因为这里使用的是模糊查询，所以这里使用百分号

        // 封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        // 1 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 获取 mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        List<Brand> brands = brandMapper.selectByIdConditionSingle(brand);
        System.out.println(brands);

        // 5 释放资源
        sqlSession.close();
    }
}
