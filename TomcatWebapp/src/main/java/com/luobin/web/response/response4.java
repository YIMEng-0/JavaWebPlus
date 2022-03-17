package com.luobin.web.response; /**
 * @author Doraemon
 * @date 2022/3/11 5:20 下午
 * @version 1.0
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应字节数据，设置字节数据的响应体
 */

@WebServlet("/resp4")
public class response4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 读取文件
        FileInputStream fis = new FileInputStream("img.png");

        // 获取字节输出流
        ServletOutputStream os = response.getOutputStream();

        // 完成流的 copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//
//        while ((len = fis.read(buff)) != -1) {
//            os.write(buff, 0, len);
//        }

        // 完成拷贝，输入流，输出流作为参数输到下面的方法中即可
        // 使用 common-io 可以简化 流的代码的书写
        IOUtils.copy(fis, os);

        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}