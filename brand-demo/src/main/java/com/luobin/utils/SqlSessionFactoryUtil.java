package com.luobin.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Doraemon
 * @date 2022/3/12 11:37 上午
 * @version 1.0
 */
public class SqlSessionFactoryUtil {
    // 提升作用域，不然只是会在 代码块中是不合适的
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 下面的静态代码块会随着类的加载从而自动执行，并且只会执行一次；
        // 因为工厂创建的太多会影响整个系统的运行效率
        // 2 调取 Mybatis 完成查询
        // 2.1 获取 SqlSessionFactory
        // 1 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getSqlSessionFactory () {
        return sqlSessionFactory;
    }

}
