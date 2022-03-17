<%--
  Created by IntelliJ IDEA.
  User: yimeng
  Date: 2022/3/13
  Time: 2:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加品牌</title>
    </head>
    <body>
        <h3>添加品牌</h3>
        <form action="/brand-demo/AddServlet" method="post">
            品牌名称：<input name="brandName"><br>
            企业名称：<input name="companyName"><br>
            排序：<input name="ordered"><br>
            描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
            状态：
            <input type="radio" name="status" value="0">禁用
            <input type="radio" name="status" value="1">启用<br>

            <input type="submit" value="提交">
        </form>
    </body>
</html>
