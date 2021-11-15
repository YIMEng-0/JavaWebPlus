package com.luobin.servlet.myservlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2021/11/15 5:28 下午
 * @version 1.0
 */

/**
 *  在这个地方写了一个标准比较通用的Servlet ，叫做GenericServlet
 *      在以后的Servlet 类都是不需要直接实现 Servlet 接口的，间接的进行GenericServlet 类的集成就可以，这样子可以只去实现自己
 *      比较常用方法，使得书写的 Servlet 类的代码变得更加简洁一些
 *
 *  GenericServlet 本身就是一个适配器的角色；
 */
public abstract class GenericServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * 下面的方法使用起来最频繁，将其设置为抽象方法，让继承它的子类进行实现即可
     *      在继承的子类中是必须实现这个方法的；
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public abstract void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
