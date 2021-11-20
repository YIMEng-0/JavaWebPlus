package com.luobin.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author Doraemon
 * @date 2021/11/16 8:15 下午
 * @version 1.0
 */

/**
 * 下面的ConfigTestServlet02 中继承了 GenericServlet 抽象类，实现了里面的抽象方法，就是创建了Servlet 对象
 */
public class ConfigTestServlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // ServletConfig 类将标签里面的进行进行了包装，使得可以在这里进行相关东西的调用，方便使用，程序可以更加高效的biancheng
        ServletConfig config = this.getServletConfig();
        out.println("ConfigTestServlet02 里面的 ServletConfig 对象为：" + config);

        // 获取到 Servlet name
        out.println("<br>");
        out.println("This is new deploy Test");
        out.println("<br>");
        out.println("OKOKOK");

        out.println("");
        System.out.println(config.getServletName());
        out.println(config.getServletName());

        // 通过使用ServletConfig 对象的两个方法，可以获取到 web.xml 文件中的初始化参数配置信息；
        // 初始化参数的名字的获取
        //
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        // 遍历集合
        out.println("<br>");
        while (initParameterNames.hasMoreElements()) {
            String parameterName = initParameterNames.nextElement();
            out.println("<br>");
            out.println("parameterName = " + parameterName);
        }

        out.println("<br>");
        String username = config.getInitParameter("username");
        out.println("username = " + username);

        out.println("<br>");
        String password = config.getInitParameter("password");
        out.println("password = " + username);

        out.println("<br>");
        String servletName = config.getServletName();
        out.println("servletName = " + servletName);

        // 使用this 调用了 ServletConfig 里面的方法也是可以的，因为Generic 这个方法实现了ServletConfig 这个接口，
        // 父类是具有这个方法的，所以子类可以直接调用即可，不需要中间的对象的创建了
        this.getInitParameterNames();
        this.getInitParameter("username");

        // 创建 ServletContext 对象
        // 使用了ServletConfig 对象进行获取ServletContext 对象
        out.println("<br>");
        ServletContext application = config.getServletContext();
        out.println("ServletContext Object is + " + application);

        ServletContext application1 = this.getServletContext();
        out.println("<br>" + " 使用了 继承了GenericServlet 的 Servlet 对象的this 创建的 ServletContext 对象 " + application1);
    }
}