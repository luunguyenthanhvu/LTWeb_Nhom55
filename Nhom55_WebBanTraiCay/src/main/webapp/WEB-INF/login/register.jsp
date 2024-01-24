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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login-css/my-style.css">
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login-css/font-awesome.css">
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
                <input type="text" placeholder="Tên người dùng" name="username">
                <input type="text" placeholder="Số điện thoại" name="phoneNum">
                <input type="text" placeholder="Địa chỉ" name="address">

                <input type="email" placeholder="Email" name="email" id="email_nd" value="${email_user}">
                <span class="error" id="email-error" style="display: none;color: red; font-size: 14px;"></span>
                <c:if test="${not empty error_email}">
                    <p style="color: red; padding: 10px; text-align: center"> ${error_email}</p>
                </c:if>

                <input type="password" placeholder="Mật khẩu" name="password" id="password_nd" value="${pass_user}">
                <span class="error" id="password-error"
                      style="display: none;color: red; font-size: 14px"></span>
                <c:if test="${not empty error_password}">
                    <p style="color: red; padding: 10px; text-align: center"> ${error_password}</p>
                </c:if>
                <c:if test="${not empty result}" >
                    <p style="color: red;padding: 10px; text-align: center"> ${result}</p>
                </c:if>
                <input type="submit" value="Đăng ký">
            </form>
            <div class="second-section w3_section">
            </div>

            <div class="bottom-text w3_bottom_text">
                <p>Bạn đã có tài khoản?<a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
            </div>
        </div>
    </div>

</div>

<div class="footer-w3l">

</div>

<script>
    // validate for input
    var email = document.getElementById("email_nd");
    var password = document.getElementById("password_nd");

    function validateEmail() {
        var text = email.value;
        var kyTuHopLe = /^[\p{L}\s']+$/u;
        var error = document.getElementById("email-error");

        if (text.length == 0 || text == null) {
            error.textContent = "Vui lòng nhập email";
            error.style.display = "block";
            return false;
        } else if (!kyTuHopLe.test(text)) {
            // Check if the email contains "@gmail.com"
            if (!text.includes("@gmail.com")) {
                error.textContent = "Email phải chứa địa chỉ @gmail.com";
                error.style.display = "block";
                return false;
            }
            error.style.display = "block";
            return false;
        } else {
            error.style.display = "none";
            return true;
        }
    }

    function validatePassword() {
        var text = document.getElementById("password_nd").value;
        var error = document.getElementById("password-error");

        if (text.length === 0) {
            error.textContent = "Vui lòng nhập mật khẩu";
            error.style.display = "block";
            return false;
        } else if (text.length < 6) {
            error.textContent = "Mật khẩu phải chứa ít nhất 6 ký tự";
            error.style.display = "block";
            return false;
        } else {
            error.style.display = "none";
            return true;
        }
    }


    // add event to check input
    email.addEventListener("blur", validateEmail);
    password.addEventListener("blur", validatePassword);

</script>

</body>
</html>
