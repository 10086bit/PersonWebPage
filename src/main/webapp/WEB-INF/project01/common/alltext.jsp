<%--
  Created by IntelliJ IDEA.
  User: 28467
  Date: 2021/6/4
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            loadData();
            $("#btn").click(function (){
                loadData();
            })
        })

        function loadData(){
            $.ajax({
                url:"${pageContext.request.contextPath}/showtexts",
                type:"get",
                dataType:"json",
                success:function (data){
                    /*刷新*/
                    $("#info").html("")

                    $.each(data,function (i,n){
                        $("#info").append("<tr>")

                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center"></div>
<table>
    <tbody id="info">
    <input type="button" id="btn" value="刷新">
    </tbody>
</table>
<form action="${pageContext.request.contextPath}/articlepageChange" method="post">
    <input type="hidden" name="pre" value="-1">
    <input type="submit" value="上一页" id="btn2">
</form>

<form action="${pageContext.request.contextPath}/articlepageChange" method="post">
    <input type="hidden" name="pre" value="1">
    <input type="submit" value="下一页" id="btn3">
</form>
</body>
</html>
