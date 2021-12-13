package com.luobin.oa.web.action; /**
 * @author Doraemon
 * @date 2021/12/13 7:26 下午
 * @version 1.0
 */

import com.luobin.utils.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 根据部门的编号，实现部门的删除
        // 获取部门的编号
        String deptno = request.getParameter("deptno");

        // 连接数据库进行删除
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DBUtil.getConnection();
            // 开启事务(自动提交机制的关闭)
            conn.setAutoCommit(false);

            String sql = "delete from dept where deptno = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            count = ps.executeUpdate();  // count 返回值是，这个操作影响了多少条记录，删除一行数据 count 就是 1

            // 事务提交
            conn.commit();

        } catch (SQLException e) {
            // 遇到了异常需要回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }

        // 判断删除成功还是失败
        if (count == 1) {
            // 仍然跳转到部门列表的页面
            // 部门的页面显示需要调用另外一个 Servlet 程序 怎么处理？转发 从一个 Servlet 转发到另外一个 Servlet
            request.getRequestDispatcher("/dept/list").forward(request, response);
        } else {
            request.getRequestDispatcher("/error.html").forward(request, response);
        }
    }

}
