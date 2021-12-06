package com.luobin.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Doraemon
 * @date 2021/12/5 5:12 下午
 * @version 1.0
 */
public class HelloServlet extends HttpServlet {
    // 无参数构造的方法会被执行的，是不需要管的目前
    // 通过无参数构造的方法构造对象，是看不见的
    public HelloServlet() {
    }

    // 没有提供 init 的方法，一定是执行父类 HttpServlet 的 init 方法的
    // HttpServlet 里面是没有 init 方法的，所有继续调用它的父类 GenericServlet 类中的 init 方法
    // 先调用 有参数的 init 方法，有参数的 init 方法调用无参数的 init 方法

    // 没有执行 service 方法，是会执行父类 HttpServlet里面 的 service 方法的，HttpServlet 里面是存在 service 方法的
    // 不可能执行 GenericServlet 方法的
    // 所以最终调用了 HttpServlet 里面的 service 方法
    // HttpServlet 里面存在了两个 service 方法，调用没有 http 的那个方法先


//    // 重写带有 http 的 service 方法
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<h1>Hello Servlet</h1>");
//    }




    // 当前端发送的是 get 请求时，重写 doGet 请求
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>doGet 请求执行了</h1>");
    }

    /**
     * HttpServlet 类里面的 doGet 方法执行了之后，一定会报 405 错误的，前端的，因为这个方法里面本身就是会报错的
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    // 当前端发送的是 post 请求时，重写 doPost 请求
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>doPost 方法执行了</h1>");
    }
}