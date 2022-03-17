package com.luobin.web; /**
 * @author Doraemon
 * @date 2022/3/13 5:13 下午
 * @version 1.0
 */

import com.luobin.pojo.Brand;
import com.luobin.service.BrandService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收 id
        String id = request.getParameter("id");

        // service 进行查询
        Brand brand = service.selectById(Integer.parseInt(id));

        // 存储到 request 中
        request.setAttribute("brand",brand);

        // 转发到 Update.jsp 中
        request.getRequestDispatcher("/Update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
