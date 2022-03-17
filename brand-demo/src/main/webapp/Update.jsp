<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--如果接收不到转发的数据，添加下面的代码 是因为 jsp 和 servlet 版本导致的默认关闭--%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>修改品牌</title>
    </head>
    <body>
        <h3>修改品牌</h3>
        <form action="/brand-demo/updateServlet" method="post">

            <%--隐藏域，提交id--%>
            <input type="hidden" name="id" value="${brand.id}">

            品牌名称：<input name="brandName" value="${brand.brandName}"><br>
            企业名称：<input name="companyName" value="${brand.companyName}"><br>
            排序：<input name="ordered" value="${brand.ordered}"><br>
            描述信息：<textarea rows="5" cols="20" name="description">${brand.description} </textarea><br>
            状态：
            <c:if test="${brand.status == 0}">
                <input type="radio" name="status" value="0" checked>禁用
                <input type="radio" name="status" value="1">启用<br>
            </c:if>

            <c:if test="${brand.status == 1}">
                <input type="radio" name="status" value="0" >禁用
                <input type="radio" name="status" value="1" checked>启用<br>
            </c:if>
            <input type="submit" value="提交">
        </form>
    </body>
</html>
