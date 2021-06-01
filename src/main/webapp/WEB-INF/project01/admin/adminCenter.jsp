<%--
  Created by IntelliJ IDEA.
  User: 28467
  Date: 2021/5/26
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            toUser();

        })
        function toUser(){
            $.ajax({
                url:"${pageContext.request.contextPath}/showOwnHead",
                type:"get",
                dataType:"json",
                success:function (data){
                    $("#btn").append("<img src="+data.faddress+" alt='head' width='100' height='100' border-radius:10px;>")
                }
            })
        }
    </script>
</head>
<body>

<a href="${pageContext.request.contextPath}/toCenter" id="btn"></a>
<a href="${pageContext.request.contextPath}/usermanage">用户管理</a><br>
<a href="${pageContext.request.contextPath}/outAdminUser">退出登入</a><br>
${tips}
</body>
</html>
