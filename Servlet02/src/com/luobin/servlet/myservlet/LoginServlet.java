package com.luobin.servlet.myservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Doraemon
 * @date 2021/11/15 5:37 下午
 * @version 1.0
 */
public class LoginServlet extends GenericServlet {
    /**
     *  思考：
     *     有没有可能在 LoginServlet 这个类中进行 init 方法的重写？
     *          当然是有可能的，这样子可能把父类写好的 init 方法破坏掉了，所以禁止重写；
     *          在方法的前面加上 final 即可，不能重写了；
     *          虽然这样保证了 init 方法的安全性，但是还有一定的问题
     *
     *    父类将原始的 init 方法 final 了，但是子类就是想要重写，应该怎么办呢？
     *          使用了下面的处理方式，在父类中再次写一个 init 方法，让子类有可以使用的东西
     */
    @Override
    public void init() {
        System.out.println("LoginServlet 重写了自己的 init 方法，制定了自己的规则执行了");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("正在处理用户的登录请求，请稍后");

        // 想要在 LoginServlet 这个子类中使用 ServiceConfig 对象？
        ServletConfig config = this.getServletConfig();

        System.out.println("LoginServlet 中 service 可以获取到的 ServletConfig 对象：" + config);
    }
}