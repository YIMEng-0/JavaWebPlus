package com.luobin.cookie; /**
 * @author Doraemon
 * @date 2022/3/13 8:13 下午
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 创建 Cookie 对象
        Cookie cookie = new Cookie("username","zs");

        // 设置存活时间
        cookie.setMaxAge(60 * 60 * 24 * 7);

        // 2 发送 Cookie response
        response.addCookie(cookie);
        System.out.println("aServlet 存活");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
