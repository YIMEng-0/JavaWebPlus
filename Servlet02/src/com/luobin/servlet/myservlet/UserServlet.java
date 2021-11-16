package com.luobin.servlet.myservlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2021/11/15 9:47 下午
 * @version 1.0
 */
public class UserServlet extends GenericServlet { // 继承的是 sun 公司写好的 Generic 不用继承自己写的东西；正宗的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("UserServlet 的 service 方法在这里执行了...");
    }
}