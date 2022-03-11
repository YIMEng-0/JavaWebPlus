package com.luobin.mapper;


import com.luobin.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    // 接口中隐藏了 public abstract 接口中只是存在抽象方法

    // 查询所有的品牌
    // 分析业务需要的方法
    List<Brand> selectAll();

    // 查看详情 就是根据 id 完成一次数据库的查询操作而已
    Brand selectById(int id);

    /**
     * 传递参数的条件查询
     *      参数接收
     *          1、散装的参数
     *              如果方法中有多个参数，需要使用 @Param 并且里面的参数需要和 sql 里面的占位符之间是对应的
     *          2、对象参数
     *              对象名称属性需要和参数占位符名称一致
     *          3、map 集合
     *
     */
//     1、 List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String
//            companyName, @Param("brandName") String brandName);

//     2、 List<Brand> selectByCondition(Brand brand);
//
    List<Brand> selectByCondition(Map map);  // 3、关于条件查询的第三种方式

    List<Brand> selectByIdConditionSingle(Brand brand);

    void add(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    // 批量删除
    void deleteByIds(int[] ids);
}
