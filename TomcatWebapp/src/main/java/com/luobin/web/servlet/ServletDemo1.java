package com.luobin.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2022/3/10 8:41 下午
 * @version 1.0
 */

// 配置访问路径，方便程序的访问
@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {
    // 实现了接口，要将接口中的抽象方法全部实现
    // 将来的 Servlet 被访问的时候 service() 方法是会自动被访问执行

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
