package com.luobin.mapper;

import com.luobin.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Doraemon
 * @date 2022/3/11 9:59 下午
 * @version 1.0
 */
public interface UserMapper {
    // 简单的 SQL 语句使用注解会变得更加简单一点，没有要使用 xml 配置
    // 根据用户名以及密码查询用户对象
    @Select("select * from db1.tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);


    /**
     * 根据用户名查询用户对象，完成注册操作
     * @param username
     * @return
     */
    @Select("select * from db1.tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 添加用户，进行注册
     * @param user
     */
    @Insert("insert into db1.tb_user values (null,#{username},#{password})")
    void add(User user);
}
