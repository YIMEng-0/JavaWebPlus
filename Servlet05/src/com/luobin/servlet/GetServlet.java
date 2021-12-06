package com.luobin.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Doraemon
 * @date 2021/12/4 9:02 下午
 * @version 1.0
 */
public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // 设置相应的内容的类型
        PrintWriter out = response.getWriter(); // 获取输出流
        out.print("<!DOCTYPE html>");
        out.print("<html lang=\"en\">");
        out.print("    <head>");
        out.print("        <meta charset=\"UTF-8\">");
        out.print("        <title>from get service</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>from get service</h1>");
        out.print("    </body>");
        out.println("</html>");
    }
}
