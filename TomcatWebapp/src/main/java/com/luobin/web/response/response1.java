package com.luobin.web.response; /**
 * @author Doraemon
 * @date 2022/3/11 5:20 下午
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        // 重定向 设置响应状态码
        response.setStatus(302);

        // 设置响应头
        // 需要添加虚拟目录 虚拟目录就是在 pom 文件中设置的 configuration
//        response.setHeader("Location","/web-demo/resp2");

        // 简化方式完成重定向
        response.sendRedirect("/web-demo/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
