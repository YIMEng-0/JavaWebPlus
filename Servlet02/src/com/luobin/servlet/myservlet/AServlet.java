package com.luobin.servlet.myservlet;

import javax.servlet.*;
import java.io.IOException;
import java.security.Provider;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/10 2:36 下午
 */

// 在创建对象的时候 Tomcat 会自动的进行对象的创建，只会创建出来一个对象，但是不是一个真的单例，是一个假的单例
// 是多线程共享的一个对象
// 真的单例模式是构造参数私有化的，这个显然不是的
public class AServlet implements Servlet {
    // 无参数构造函数


    // 进行第一次的服务的调用的时候，调用这个构造方法;使用的是反射机制进行调用此方法
    // 这个方法执行了之后然后进行 init
    public AServlet() {
        System.out.println("AServlet 无参数构造方法执行了！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("AServlet's init method execute");
    }

    // 进行请求多少次，这个服务的方法就会执行多少次
    // AServlet 请求的时候进行服务的开始
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet's service method execute");
    }


    /**
     * 只是会执行一次
     *      Tomcat 服务器在销毁对象之前进行这个方法的执行
     *      在这个方法中可以编写在销毁前面的准备
     *      比如说在AServlet 对象中开启了一些资源，这些资源是流，可能是数据库连接，关闭服务器的时候，需要关闭相关的流，这些关闭的代码可以书写在这个地方
     */
    @Override
    public void destroy() {
        System.out.println("AServlet's destroy method execute");
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