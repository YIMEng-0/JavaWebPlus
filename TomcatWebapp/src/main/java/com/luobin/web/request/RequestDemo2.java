package com.luobin.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Doraemon
 * @date 2022/3/11 12:10 下午
 * @version 1.0
 */

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get 请求逻辑
        System.out.println("get...");

        // 获取 key
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + ":");

            // 获取 value
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
        }

        // 获取前端传递进来的数据（可能是数字或者文件）
        System.out.println("---------");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post 请求逻辑
        doGet(req, resp);
    }
}
