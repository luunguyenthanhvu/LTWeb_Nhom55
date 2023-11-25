<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 18/11/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Đăng ký tài khoản</title>
    <!-- custom-theme -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Elegant Login Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //custom-theme  -->
    <link rel="stylesheet" href="../../static/css/style.css">
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="../../static/css/font-awesome.css">
    <!-- //font-awesome icons -->
    <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
</head>
<body>
<div class="login-form w3_form">
    <!--  Title-->
    <div class="login-title w3_title" >



    </div>
    <div class="login w3_login">
        <h2 class="login-header w3_header">Đăng ký</h2>
        <div class="w3l_grid">
            <form class="login-container" action="register" method="post">
                <input type="text" placeholder="Tên người dùng" name="username" required >
                <input type="text" placeholder="Số điện thoại" name="phoneNum" required >
                <input type="text" placeholder="Địa chỉ" name="address" required>
                <input type="email" placeholder="Email" name="email" required>
                <input type="password" placeholder="Mật khẩu" name="password" required>
                <c:if test="${not empty userExist}" >
                    <p style="color: red;padding: 10px; text-align: center"> ${userExist}</p>
                </c:if>
                <input type="submit" value="Đăng ký">
            </form>
        </div>
    </div>

</div>





<div class="footer-w3l">

</div>
</body>
</html>
