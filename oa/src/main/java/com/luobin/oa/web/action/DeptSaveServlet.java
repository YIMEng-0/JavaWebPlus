package com.luobin.oa.web.action;

/**
 * @author Doraemon
 * @date 2021/12/13 9:36 下午
 * @version 1.0
 */

import com.luobin.utils.DBUtil;
import sun.util.locale.StringTokenIterator;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 获取部门的信息
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");

        // 连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {

            conn = DBUtil.getConnection();
            String sql = "insert into dept(deptno, dname,loc) values (?,?,?)";
            ps = conn.prepareStatement(sql);

            // 前端获取到的三个数据在数据库中进行插入的操作
            ps.setString(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);

            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }


        if (count == 1) {
            // 保存成功跳转到列表页面
            request.getRequestDispatcher("/dept/list").forward(request, response);
        } else {
            // 保存失败，跳转到错误的页面
            request.getRequestDispatcher("/error.html").forward(request, response);
        }
    }
}
