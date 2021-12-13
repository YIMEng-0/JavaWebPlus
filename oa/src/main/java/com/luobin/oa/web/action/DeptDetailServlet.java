package com.luobin.oa.web.action; /**
 * @author Doraemon
 * @date 2021/12/12 5:18 下午
 * @version 1.0
 */

import com.luobin.utils.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 连接数据库，根据部分的编号，查询部门的信息，动态的展示部门详情页面
        // 获取部门编号
        // 提交的是 30 但是在最终提交的是一个字符串
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>部门详情</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>部门详情</h1>");
        out.print("        <hr >");

        String deptno = request.getParameter("deptno");

        // 连接数据库，根据部门编号获取部门的信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select dname,loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            rs = ps.executeQuery(); ///////////////////////////执行SQL 语句！！！！！

            // 查询出来的结果集合中是只会存在一条记录的
            if (rs.next()) {
                String dname = rs.getString("dname");
                System.out.println(dname);
                String loc = rs.getString("loc");

                out.print("部门编号："+deptno+" <br>");
                out.print("部门名称："+dname+" <br>");
                out.print("部门位置："+loc+" <br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        out.print("    </body>");
        out.print("    <a href='list.html'>回到 list 界面</a>");
        out.print("    <br>");
        out.print("    <input type='button' value='后退' onclick='window.history.back()'/>");
        out.print("    ");
        out.print("</html>");
    }
}
