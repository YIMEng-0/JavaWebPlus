package com.luobin.web; /**
 * @author Doraemon
 * @date 2022/3/11 3:25 下午
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 输入的中文可能存在乱码的问题，进行解决
        // 因为字符集是不一样的，所以在这里是需要重新设定编码的
        request.setCharacterEncoding("UTF-8");

        // 前端得到输入的参数
        String username = request.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
