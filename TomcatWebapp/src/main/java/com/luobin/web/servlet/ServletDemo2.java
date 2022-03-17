package com.luobin.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2022/3/10 8:41 下午
 * @version 1.0
 */

// 配置访问路径，方便程序的访问
@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
    // 实现了接口，要将接口中的抽象方法全部实现
    // 将来的 Servlet 被访问的时候 service() 方法是会自动被访问执行

    /**
     * 初始化的方法
     *      调用时机 默认情况下 Servlet 第一次 被访问的时候被调用,被调用之前创建了对象
     *              在类上面配置了 loadOnStartup 的时候，可以考虑在 Tomcat 启动的时候，开始服务
     *      调用次数 调用一次 在控制台上面只能看到一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 提供服务
     *      调用时机 每一次 访问servlet 的时候，就是界面刷新的时候
     *      调用次数 可以调用多次，服务是多次的不是一次性的
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    /**
     *      调用时机 内存释放的时候，服务器关闭的时候，Servlet 对象会被销毁，调用这个方法
     *      调用次数 一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
