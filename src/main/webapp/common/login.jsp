<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js">
    </script>
    <script type="text/javascript">
     //做刷新和回调函数（未完成）
    </script>
</head>
<body>
<form  method="post" action="${pageContext.request.contextPath}/loginUsercontroller">
    name<input type="text" name="u_name">
    age<input type="text" name="u_passwd">
    <input type="submit" value="提交" >
</form>

</body>
</html>
