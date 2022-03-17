<%--
  Created by IntelliJ IDEA.
  User: yimeng
  Date: 2022/3/12
  Time: 5:58 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--如果接收不到转发的数据，添加下面的代码 是因为 jsp 和 servlet 版本导致的默认关闭--%>
<%@page isELIgnored="false" %>
>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        ${brands}
    </body>
</html>
