package com.luobin.oa.web.action; /**
 * @author Doraemon
 * @date 2021/12/13 9:36 下午
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeptSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        System.out.println(deptno);
        System.out.println(dname);
        System.out.println(loc);

        // 获取部门的信息
        // 连接数据库
        // 保存成功跳转到列表页面
        // 保存失败，跳转到错误的页面
    }
}
