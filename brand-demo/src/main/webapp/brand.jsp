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
        <hr>
        <table border="1" cellspacing="0" width="80%">
            <tr>
                <th>序号</th>
                <th>品牌名称</th>
                <th>企业名称</th>
                <th>排序</th>
                <th>品牌介绍</th>
                <th>状态</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${brands}" var="brand" varStatus="status">
                <tr align="center">
                        <%--<td>${brand.id}</td>--%>
                    <td>${status.count}</td>
                    <td>${brand.brandName}</td>
                    <td>${brand.companyName}</td>
                    <td>${brand.ordered}</td>
                    <td>${brand.description}</td>
                    <c:if test="${brand.status == 1}">
                        <td>启用</td>
                    </c:if>
                    <c:if test="${brand.status != 1}">
                        <td>禁用</td>
                    </c:if>
                    <td><a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a> <a href="#">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>