package com.luobin.servlet.myservlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2021/11/15 5:50 下午
 * @version 1.0
 */
public class VIPServlet extends GenericServlet{
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("VIP 正在登录中，请稍后...");
    }
}
