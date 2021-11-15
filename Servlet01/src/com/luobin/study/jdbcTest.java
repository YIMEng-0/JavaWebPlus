package com.luobin.study;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/10 10:10 上午
 */
public class jdbcTest {
    public static void main(String[] args) {
        // 设置相应的内容的类型

        // 编写 jdbc 代码，进行数据库的连接，记性数据的查询操作
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

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
            String sql = "select DNAME from DEPT";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // 处理查询结果集
            while (rs.next()) {
                String dname = rs.getString("DNAME");
                System.out.println(dname);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                SQLException throwables) {
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
}
