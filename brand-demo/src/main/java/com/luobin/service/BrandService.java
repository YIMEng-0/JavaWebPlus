package com.luobin.service;

import com.luobin.mapper.BrandMapper;
import com.luobin.pojo.Brand;
import com.luobin.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Doraemon
 * @date 2022/3/13 1:54 下午
 * @version 1.0
 */
public class BrandService {
    // 通过提前写好的 utils 里面的工具创建一次工厂，减少系统的资源浪费
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll() {
        // 调用 BrandMapper.selectAll()

        // 获得 SqlSessionFactory() 创建 sqlSession 对象方便执行 sql 语句
//        SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

        SqlSession sqlSession = factory.openSession();

        // 获取 BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 调用方法
        List<Brand> brands = mapper.selectAll();

        // 因为知识查询操作，所以是不需要提交事务的，知识将资源进行关闭即可
        sqlSession.close();

        return brands;
    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 调用方法
        mapper.add(brand);

        // 增删改的操作，需要事务的提交
        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 查询进行回显操作
     * @return
     */
    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();

        // 获取 BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 调用方法
        Brand brand = mapper.selectById(id);

        // 因为知识查询操作，所以是不需要提交事务的，知识将资源进行关闭即可
        sqlSession.close();

        return brand;
    }
}