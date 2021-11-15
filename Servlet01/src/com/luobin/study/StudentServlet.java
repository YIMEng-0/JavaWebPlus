package com.luobin.study;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/9 5:11 下午
 */
public class StudentServlet implements Servlet {

    /**
     * init 翻译的意思是：初始化，init 只会执行一次，在 AService 执行第一次的时候会被执行
     * init 方法通常实在完成初始化操作的
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 处理用户请求的核心方法
     * 只要用户发送一次请求，service 方法一定会被执行一次
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 设置相应的内容的类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 编写 jdbc 代码，进行数据库的连接，记性数据的查询操作
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 进行配置文件的获取，获取到进入数据库的权限，进行数据库的操作权限
        // 进行配置文件的获取，获取到进入数据库的权限，进行数据库的操作权限
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/data";
        String username="root";
        String password="9842213764";

        try {
            // 获取驱动，进行驱动的连接
            Class.forName(driver);

            // 获取连接
            conn = DriverManager.getConnection(url, username, password);

            // 获取预编译的数据库操作对象
            String sql = "select ENAME from EMP";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // 处理查询结果集

            while (rs.next()) {
                String dname = rs.getString("ENAME");
                out.println();
                out.println(dname);
                System.out.println(dname);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}