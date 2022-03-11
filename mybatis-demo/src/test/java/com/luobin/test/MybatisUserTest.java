package com.luobin.test;

import com.luobin.mapper.UserMapper;
import com.luobin.pojo.User;
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
 * @date 2022/3/6 11:10 上午
 * @version 1.0
 */
public class MybatisUserTest {
    @Test
    public static void main(String[] args) throws IOException {
        // 1 加载 mybatis 的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 获取 SqlSession 对象，用来执行 sql 语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 执行 sql
        // test 是UserMapper 里面的额 namespace 将来用来区分不同的 Mapper
        // 执行 sql 语句是执行其 sql 的唯一标识符 id ，在 UserMapper 里面设置的是 selectAll
//        List<User> users = sqlSession.selectList("test.selectAll");

        // 3.1 获取到 UserMapper 接口的代理对象
        // 获取代理对象的过程由 MyBatis 内部进行实现
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        /**
         * 代码的执行流程：
         *      getMapper 获取到了 UserMapper 接口
         *      UserMapper 接口找到了 UserMapper.xml (在 sql 映射文件中存在 sql 语句)
         *      代理对象可以通过 UserMapper.xml 里面的 id 找到需要执行的 sql 语句，实现数据库的操作
         */
        List<User> users = userMapper.selectAll();
        // 通过了 Mapper 代理的方式，避免了硬编码；

        // 将最终的结果进行打印即可，打印出来的是前面自己 重写 的 toString（） 方法
        System.out.println(users);
        sqlSession.close();
        System.out.println();
    }
}
