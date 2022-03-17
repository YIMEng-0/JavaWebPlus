package com.luobin.web.request; /**
 * @author Doraemon
 * @date 2022/3/11 3:44 下午
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/req5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo5...");

        // 存储数据
        request.setAttribute("message","hello");

        // 请求转发
        // 请求转发的路径
        request.getRequestDispatcher("/req6").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
