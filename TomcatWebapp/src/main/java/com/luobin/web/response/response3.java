package com.luobin.web.response; /**
 * @author Doraemon
 * @date 2022/3/11 5:20 下午
 * @version 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.interfaces.RSAKey;

/**
 * 相应字符数据，设置字符数据的响应体
 */

@WebServlet("/resp3")
public class response3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 防止出现乱码，可以解析 html 文档的设置 设置响应格式以及字符集
        response.setContentType("text/html;charset = utf-8");

        System.out.println("resp3...");
        // 获取字符输出流

        PrintWriter writer = response.getWriter();

        writer.write("你好");
        writer.write("<h1>aaa<h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}