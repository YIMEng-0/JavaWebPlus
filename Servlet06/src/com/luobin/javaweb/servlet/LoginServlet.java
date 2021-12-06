package com.luobin.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Doraemon
 * @date 2021/12/6 7:11 下午
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {

    // 对于 doGet 方法 或者 doPost 方法的重写
    // 两个方法只是需要重写一个就行，没有必要重写两个方法，两个都重新写了之后，会享受不到 405 错误，浪费了 http 协议的加入
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 随意写代码
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>login Succeed...</h1>");
    }
}
