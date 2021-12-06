package com.luobin.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Doraemon
 * @date 2021/12/4 9:04 下午
 * @version 1.0
 */
public class PostServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 在这里相应一些内容返回到达浏览器上面
        response.setContentType("text/html"); // 设置相应的内容的类型
        PrintWriter out = response.getWriter(); // 获取输出流

        // println 是源代码换行，不是输出到页面的效果进行换行，页面的换行效果需要使用<br> 标签进行实现
        out.print("<!DOCTYPE html>");
        out.print("<html lang=\"en\">");
        out.print("    <head>");
        out.print("        <meta charset=\"UTF-8\">");
        out.print("        <title>from post service</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>from post service</h1>");
        out.print("    </body>");
        out.println("</html>");
    }
}
