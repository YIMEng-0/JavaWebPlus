package com.luobin.oa.web.action; /**
 * @author Doraemon
 * @date 2021/12/12 2:19 下午
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

public class DeptListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的内容以及字符集，防止中文的乱码问题
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取应用的根路径
        String contextPath = request.getContextPath();

        out.print("<!DOCTYPE html>");

        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title></title>");
        out.print("    </head>");

        // 关于Javascript 脚本里面的东西，在Java里面是不识别的，但是在浏览器上面是可以识别的
        out.print("<script type='text/javascript'>");
        out.print("    function del(dno) {");
        out.print("        ");
        out.print("        if (window.confirm('确定删除？')) {");
        out.print("            document.location.href = '/oa/dept/delete?deptno=' + dno;");
        out.print("        }");
        out.print("    }");
        out.print("</script>");

        out.print("    <body>");
        out.print("        <h1 align='center'>部门列表</h1>");
        out.print("        <hr>");
        out.print("        <table border='1' align='center' width='50%'>");
        out.print("            <tr>");
        out.print("                <th>序号</th>");
        out.print("                <th>部门编号</th>");
        out.print("                <th>部门名称</th>");
        out.print("                <th>操作</th>");
        out.print("            </tr>");

        // 在这个方法中，写 doGet 方法，可以使得查询所有的部门，并且在前端动态的显示执行的结果
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 获取连接
            conn = DBUtil.getConnection();
            // 获取预编译的数据库操作对象
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            // 执行 sql 语句
            rs = ps.executeQuery();

            int i = 0;
            // 处理查询结果集合
            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                // 下面的界面进行动态的展示
                out.print("            <tr>");
                out.print("                <td>" + (++i) + "</td>");
                out.print("                <td>" + deptno + "</td>");
                out.print("                <td>" + dname + "</td>");
                out.print("                <td>");
                out.print("                    <a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                out.print("                    <a href='edit.html'>修改</a>");
                out.print("                    <a href='" + contextPath + "/dept/detail?deptno=" + deptno + "'>详情</a>");
                out.print("                    ");
                out.print("                </td>");
                out.print("            </tr>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        /**
         * 下面的代码是不需要修改的
         */

        out.print("        </table>");
        out.print("        <a href='"+contextPath+"/add.html'>增加</a>");
        System.out.println(contextPath);
        out.print("    </body>");

        System.out.println("执行到了下面");

        out.print("</html>");

    }
}