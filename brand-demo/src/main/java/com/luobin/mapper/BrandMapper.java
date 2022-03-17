package com.luobin.mapper;

import com.luobin.pojo.Brand;
import com.luobin.service.BrandService;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Doraemon
 * @date 2022/3/13 11:59 上午
 * @version 1.0
 */
public interface BrandMapper {
    /**
     * 查询 tb_brand 表中的所有数据
     * @return
     */
    @Select("select * from mybatis.tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 向数据库中添加数据
     * @param brand
     */
    @Select("insert into mybatis.tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 进行数据的回显
     * 根据 id 进行查询
     */
    @Select("select * from mybatis.tb_brand where id = #{id}")
    Brand selectById(int id);
}