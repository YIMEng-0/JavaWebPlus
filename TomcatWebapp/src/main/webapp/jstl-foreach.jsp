<%--
  Created by IntelliJ IDEA.
  User: yimeng
  Date: 2022/3/12
  Time: 6:16 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--如果接收不到转发的数据，添加下面的代码 是因为 jsp 和 servlet 版本导致的默认关闭--%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <input type="button" value="新增"><br>
        <hr>
        <table border="1" cellspacing="0" width="800">
            <tr>
                <th>序号</th>
                <th>品牌名称</th>
                <th>企业名称</th>
                <th>排序</th>
                <th>品牌介绍</th>
                <th>状态</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${brands}" var="brand">
                <tr>
                    <th>${brand.id}</th>
                    <th>${brand.brandName}</th>
                    <th>${brand.companyName}</th>
                    <th>${brand.ordered}</th>
                    <th>${brand.description}</th>
                    <th>${brand.status}</th>
                </tr>
            </c:forEach>

            <c:if test="${status == 1}">
                启用
            </c:if>
            <c:if test="${status != 1}">
                禁用
            </c:if>
        </table>

    </body>
</html>