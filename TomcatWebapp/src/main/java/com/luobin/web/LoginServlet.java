package com.luobin.web; /**
 * @author Doraemon
 * @date 2022/3/11 10:12 下午
 * @version 1.0
 */

import com.luobin.mapper.UserMapper;
import com.luobin.pojo.User;
import com.luobin.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.rmi.CORBA.Util;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.WriteAbortedException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 接收用户名以及密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2 调取 Mybatis 完成查询
        // 2.1 获取 SqlSessionFactory
        // 1 获取 SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        // 2.2 获取sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.3 获取 Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 2.4 调用方法
        User user = userMapper.select(username, password);

        // 2.5 释放资源
        sqlSession.close();

        // 获取对应的字符输出流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        // 3 判断 user 是不是存在的
        if (user != null) {
            writer.write("登录成功");
        } else {
            writer.write("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
