package com.luobin.web.servlet; /**
 * @author Doraemon
 * @date 2022/3/14 4:44 下午
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收用户名
        String username = request.getParameter("username");

        // 调用 service 查询 user 对象 ，测试 ajax 这里给一个 flag 表示一下即可
        // 假设查询到的用户名自是存在的
        boolean flag = true;

        // 响应标记
        response.getWriter().write("" + flag);
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
