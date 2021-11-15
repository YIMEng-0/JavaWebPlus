package com.luobin.servlet.myservlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2021/11/15 5:37 下午
 * @version 1.0
 */
public class LoginServlet extends GenericServlet{
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("正在处理用户的登录请求，请稍后");
    }
}
