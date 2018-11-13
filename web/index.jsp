<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/10
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <h5>手机：<input type="text" id="Phone"></h5>
    <h5>密码：<input type="password" id="password"></h5>
    <div><input type="text" id="Code"><input type="button" onclick="submit()" value="获取验证码"></div>
    <input type="button" id="register" value="注册">
  </div>
  </body>
</html>
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
<script>
function submit() {
    $.ajax({
        type:"post",
        url:"PhoneServlet",
        dataType:"json",
        data: {"Phone":$("#Phone").val(),}
    })
}
$("#register").click(function () {
    $.ajax({
        type:"post",
        url:"RegisterServlet",
        dataType:"json",
        data: {
            "Phone":$("#Phone").val(),
            "password":$("#password").val(),
            "Code":$("#Code").val(),
        },
        success:function (Data) {
            var num=Data;
           console.log(num);
           if(num=="1"){
               window.location.href = "http://localhost:8080/Success.jsp";
           }else{
               window.location.href = "http://localhost:8080/fail.jsp";
           }
        }
    })
});

</script>
