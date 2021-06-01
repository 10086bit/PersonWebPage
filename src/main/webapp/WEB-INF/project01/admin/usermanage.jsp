<%--
  Created by IntelliJ IDEA.
  User: 28467
  Date: 2021/5/28
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            toUser();
        })
        function toUser(){
            $.ajax({
                url:"${pageContext.request.contextPath}/showOwn",
                type:"get",
                dataType:"json",
                success:function (data){
                    $("#btn1").append("<p>"+data.u_name+"</p>")
                }
            })
        }
    </script>
    <script type="text/javascript">
        $(function (){
            loadData();
            $("#btn").click(function (){
                loadData();
            })
        })

        function loadData(){
            $.ajax({
                url:"${pageContext.request.contextPath}/showuser",
                type:"get",
                dataType:"json",
                success:function (data){
                    /*刷新*/
                    $("#info").html("")

                    $.each(data,function (i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.u_id+"<td>")
                            .append("<td>"+n.u_name+"<td>")
                            .append("<td>"+"<form action='"+"${pageContext.request.contextPath}"+"/toModUser' method='post'>"+
                                "<input type='hidden' " +
                                "name='uid' value='"+n.u_id+"'>"+"<input type='submit' " +
                                "value='查看用户详细信息'>"+"</form>"+"</td>")
                    })
                }
            })
        }
    </script>

</head>
<body>
<a href="${pageContext.request.contextPath}/toCenter" id="btn1"></a>
<div align="center">
    <table>
        <thead>
        <tr>
            <td >uid</td>
            <td>用户名</td>

        </tr>
        </thead>
        <tbody id="info">
        <input type="button" id="btn" value="查询用户">
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/pageChange" method="post">
        <input type="hidden" name="pre" value="-1">
        <input type="submit" value="上一页" id="btn2">
    </form>

    <form action="${pageContext.request.contextPath}/pageChange" method="post">
       <input type="hidden" name="pre" value="1">
        <input type="submit" value="下一页" id="btn3">
    </form>
</div>
<a href="${pageContext.request.contextPath}/tologUser" >返回主页</a>
</body>
</html>
