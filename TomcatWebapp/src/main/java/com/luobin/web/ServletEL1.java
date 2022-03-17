package com.luobin.web; /**
 * @author Doraemon
 * @date 2022/3/12 5:58 下午
 * @version 1.0
 */

import com.luobin.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/el-demo1")
public class ServletEL1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、准备数据
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1, "三只松鼠", "三只松鼠", 100, "三只松鼠，好吃不上火", 1));
        brands.add(new Brand(2, "优衣库", "优衣库", 200, "优衣库，服适人生", 0));
        brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "为发烧而生", 1));

        // 2 存储在 request 域中
        request.setAttribute("brands", brands);
        request.setAttribute("status", 1);

        // 3 转发到 el-demo.jsp 中
//        request.getRequestDispatcher("/el-demo.jsp").forward(request,response);
        request.getRequestDispatcher("/jstl-foreach.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
