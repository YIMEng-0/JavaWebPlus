<%--
  Created by IntelliJ IDEA.
  User: yimeng
  Date: 2022/3/12
  Time: 5:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--        进行逻辑判断，代替 Java 里面的 if else--%>
        <%--        EL  标签获取数据，JSTL 用来判断数据是不是符合要求--%>
        <c:if test="true">
            <h1>true</h1>
        </c:if>

        <c:if test="true">
            <h1>false</h1>
        </c:if>
    </body>
</html>
