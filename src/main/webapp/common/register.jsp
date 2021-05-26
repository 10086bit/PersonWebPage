<%--
  Created by IntelliJ IDEA.
  User: 28467
  Date: 2021/5/20
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js"> </script>

</head>
<body>
<form action="${pageContext.request.contextPath}/registerUer" method="post" >
    name<input type="text" name="u_name">
    passwd<input type="text" name="u_passwd">
    验证码：<input type="text" name="code" style="width: 100px;">
    <img src="${pageContext.request.contextPath}/kaptcha.jpg" style="width: 100px; height: 30px;"><br>${tips}
    <input type="submit" value="提交" >
</form>

</body>
</html>
