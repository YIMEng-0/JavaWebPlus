package com.luobin.web; /**
 * @author Doraemon
 * @date 2022/3/13 2:02 下午
 * @version 1.0
 */

import com.luobin.pojo.Brand;
import com.luobin.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 1
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、调用 BrandService 完成查询
//        BrandService service = new BrandService();

        List<Brand> brands = service.selectAll();

        // 2、存入到 request 域中
        request.setAttribute("brands", brands);

        // 3、转发到 brand.jsp
        request.getRequestDispatcher("/brand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
