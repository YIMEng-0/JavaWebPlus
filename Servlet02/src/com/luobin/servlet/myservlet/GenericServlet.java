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
    // 定义成员变量
    private ServletConfig config;

    /**
     * 在下面的 init 方法执行的前面，会创建出来 ServletConfig 对象，然后作为参数传递进来
     *      init 方法里面的servletConfig对象是 Tomcat 自动创建成功的
     *      此时的servletConfig 对象目前在 init 方法里面属于一个局部变量
     *      ServletConfig对象以后需要在service 方法里面也会使用，怎么才能保证 servletConfig对象在里面可以使用呢
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public final void init(ServletConfig config) throws ServletException {
        System.out.println("servletConfig 对象：" + config);
        this.config = config;
        this.init();
    }

    /**
     * 上面的 init 方法写成了 final
     * 在这个位置，重新定义一个 init 方法，让继承的子类重写这个方法即可;
     *
     * 这个没有带参数的 init 方法是提供给 子类进行重写的；
     *
     * 运行机制是，先在自己的类中寻找有没有 init 方法，没有的话就去执行父类的init 方法，自己有的话，执行自己的 init
     * 方法即可
     */
    public void init() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
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