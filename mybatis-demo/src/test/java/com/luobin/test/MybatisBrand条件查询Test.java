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

public class MybatisBrand条件查询Test {
    @Test
    public static void main(String[] args) throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数 模糊查询的时候需要使用 %% 或者下划线的占位符来对参数进行处理
        companyName = "%"+ companyName + "%";
        brandName = "%"+ brandName + "%";

        // 封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
        // 使用Map 进行参数的传递
        Map map = new HashMap();
//        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        // 1 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 获取 mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        // 返回来的是一个 所以不需要使用列表进行数据的接收
        // 1 List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName); // 散装参数查询
        // 2 List<Brand> brands = brandMapper.selectByCondition(brand); // 封装参数查询
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        // 5 释放资源
        sqlSession.close();
    }
}
