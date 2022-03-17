package com.luobin.web; /**
 * @author Doraemon
 * @date 2022/3/13 2:51 下午
 * @version 1.0
 */

import com.luobin.pojo.Brand;
import com.luobin.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 配置可能存在的乱码问题
        request.setCharacterEncoding("utf-8");

        // 1、接收表单中提交的数据，封装成为一个 Brand 对象，接收表单参数，封装成为对象的目的是将数据添加到数据库中
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        // 封装的对象的时候，因为这个数据从前端获取过来是 String ，在这里需要进行数据类型的转换
        brand.setStatus(Integer.parseInt(status));
        brand.setOrdered(Integer.parseInt(ordered));

        // 调用 service() 完成数据的添加
        service.add(brand);

        // 转发到查询所有的 Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
