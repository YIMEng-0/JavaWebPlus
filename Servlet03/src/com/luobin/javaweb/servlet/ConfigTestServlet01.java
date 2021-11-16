package com.luobin.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Doraemon
 * @date 2021/11/15 10:29 下午
 * @version 1.0
 */
public class ConfigTestServlet01 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 设置内容的类型
        // response 回应的内容为 text 或者为 html 类型的
        // 创建一个可以进行输出的对象
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); // 得到书写器，可以向着网页进行内容的书写

        // 获取到 ServletConfig 对象
        ServletConfig config = this.getServletConfig();
        out.println("ServletConfig 对象为： " + config);
        out.println("<br>");
        out.println("Hello ServletConfig");
    }
}