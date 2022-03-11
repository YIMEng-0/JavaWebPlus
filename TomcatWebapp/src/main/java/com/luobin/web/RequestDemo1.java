package com.luobin.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2022/3/11 11:36 上午
 * @version 1.0
 */

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        // 获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        // 获取 URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);

        // 获取 URI
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        // 获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //-----------

    }


    // 不能删除，会产生 5xx 的错误

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 为了统一使用一种方式进行参数的获取，不在 doGet doPost 两个里面都写获取参数的代码，简化开发，这里直接转到
        // doGet 里面执行请求以及相应代码即可
        this.doGet(req, resp);
    }
}
