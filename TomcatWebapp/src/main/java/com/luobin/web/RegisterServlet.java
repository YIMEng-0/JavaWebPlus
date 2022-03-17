package com.luobin.web; /**
 * @author Doraemon
 * @date 2022/3/12 11:22 上午
 * @version 1.0
 */

import com.luobin.mapper.UserMapper;
import com.luobin.pojo.User;
import com.luobin.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前端传递进行的用户参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 封装一个用户对象，方便传递到数据库中进行数据的查询以及用户的创建工作
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 调用 Mapper 根据里面的方法进行用户的查询
        // 2 调取 Mybatis 完成查询
        // 2.1 获取 SqlSessionFactory
        // 1 获取 SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /**
         * SqlSession 代表用户与数据库之间的连接
         *      所有的用户以及功能之间都使用一个连接是不合适的 会导致多个功能之间相互影响，不能这样子做
         */
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        // 2.2 获取sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2.3 获取 Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = userMapper.selectByUsername(username);

        // 判断用户是不是空的对象
        if (user1 == null) {
            // 用户名字不存在，进行用户的注册
            userMapper.add(user);

            // 因为完成的是 增加删除改变的操作，所以是需要提交事务的
            sqlSession.commit();

            // 释放资源
            sqlSession.close();

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("注册成功");

        } else {
            // 用户名字存在，提示一下
            // 下面存在中文的信息输出，所以进行一些符号集的设计
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
