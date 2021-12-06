package com.luobin.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Doraemon
 * @date 2021/11/17 3:26 下午
 * @version 1.0
 */
public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 获取到 ServletContext 对象
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext application = this.getServletContext();
        out.println("ServletContext 的对象为：" + application);
      
    }

}
