package com.luobin.mapper;

import com.luobin.pojo.User;

import java.util.List;

/**
 * @author Doraemon
 * @date 2022/3/6 5:29 下午
 * @version 1.0
 */
public interface UserMapper {
    // 在这里定义的返回值是一个User 对象还是一个集合 在此处是需要辨别的；
    // 目前是返回一个集合，所以在此处使用此种编写方式；
    // 根据 sql 语义进行判断
    List<User> selectAll();

    User selectById(int id);
}