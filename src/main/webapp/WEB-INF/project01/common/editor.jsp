<%--
  Created by IntelliJ IDEA.
  User: 28467
  Date: 2021/5/25
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<body>

<form action="${pageContext.request.contextPath}/saveArticle"  method="post">
    <input type="text" name="title">
    <textarea name="text" ></textarea>
    <input type="submit" value="发布">
</form>
</body>
</html>
