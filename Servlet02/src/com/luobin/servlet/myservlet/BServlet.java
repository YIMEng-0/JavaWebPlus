package com.luobin.servlet.myservlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/10 2:39 下午
 */
public class BServlet implements Servlet {
    // 无参数的构造方法
    public BServlet() {
        System.out.println("BServlet 无参数构造方法执行了！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
