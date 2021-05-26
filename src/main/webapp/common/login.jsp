<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.js">
    </script>
    <script type="text/javascript">
     //做刷新和回调函数（未完成）
    function login(){
        $.ajax({
            url:"${pageContext.request.contextPath}/loginadmin",
            type:"get",
            dataType:"json",
            success:function (tips){
                alert(tips);
            }
        })
    }

    </script>
</head>
<body>
<form  method="post">
    name<input type="text" name="name">
    age<input type="text" name="passwd">
    <input type="button" value="提交" onclick="login()">
</form>

</body>
</html>
