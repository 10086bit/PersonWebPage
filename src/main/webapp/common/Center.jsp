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
    <title>Title</title>
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
                    $("#btn2").append("<img src="+data.faddress+" alt='head' width='100' height='100' border-radius:10px;>")
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
                url:"${pageContext.request.contextPath}/showOwn",
                type:"get",
                dataType:"json",
                success:function (data){
                    /*刷新*/
                    $("#info").html("")
                    $("#info").append("<tr>")
                        .append("<td>"+data.u_name+"</td>")
                        .append("<td>"+data.u_id+"</td>")
                        .append("<td>"+data.u_passwd+"</td>")
                        .append("<td>"+data.u_head+"</td>")
                        .append("</tr>")

                }
            })
        }
    </script>

</head>
<body>

<div align="center">
    <table>
        <thead>
        <tr>
            <td>名字</td>
            <td>UID</td>
            <td>密码</td>
            <td>头像</td>
        </tr>
        </thead>
        <tbody id="info">
        <input type="button" id="btn" value="刷新">
        </tbody>

    </table>
</div>
<a href="${pageContext.request.contextPath}/toCenter" id="btn2"></a>
<div align="center" >


    <form action='${pageContext.request.contextPath}/modUser' method='post'>
        <input type='hidden' name='uid' value="<%=(int)session.getAttribute("uid")%>">
        名字<input type='text' name='u_name'>

        密码<input type='text' name='u_passwd'>
        <input type='submit' value='修改信息'>
    </form>


    ${msg}
    <br>
    <form method="POST" action="${pageContext.request.contextPath}/toUpHead" enctype="multipart/form-data">
        上传头像: <input type="file" name="file">
        <input type="submit" value="Upload">
    </form>
</div>

</body>
</html>
