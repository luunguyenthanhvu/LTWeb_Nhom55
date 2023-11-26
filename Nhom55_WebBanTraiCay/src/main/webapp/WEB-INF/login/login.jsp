<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 18/11/2023
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Đăng nhập tài khoản</title>
    <!-- custom-theme -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Elegant Login Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>

    <!-- //custom-theme  -->
    <link rel="stylesheet" href="<c:url value="./static/css/login-css/login.css"/>">
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="./static/css/login-css/font-awesome.css">
    <!-- //font-awesome icons -->
    <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="root">
        <img class="background_img" src="./static/images/bg1.jpg" alt="">
        <div class="main__container">
            <form action="Login" class="form__sign-in" method="post">
                <div class="header_form">
                    <h3>ĐĂNG NHẬP</h3>
                </div>

                <div class="input__field">
                    <input id="email" name="email" type="email" placeholder="Email">
                    <p class="error" id="email_error"></p>
                </div>
                <div class="input__field">
                    <input id="password" name="password" type="password" placeholder="Mật khẩu">
                    <p class="error" id="password_error"></p>
                </div>
                <div class="btn__sign-in">
                    <button id="signIn">Đăng nhập</button>
                </div>
                <c:if test="${not empty user}" >
                    <p style="color: red;padding-top: 20px; text-align: center"> ${user} Không tìm thấy </p>
                </c:if>

                <div class="sign__up">
                    <p>Bạn mới biết đến Shop?<a href="signup.html"> Đăng ký</a></p>
                    <h4> <a href="forget-password.html">Quên mật khẩu?</a></h4>
                </div>

            </form>
        </div>
    </div>
</div>

</body>

<script>
    var email = document.getElementById("email");
    var password = document.getElementById("password");

    function validateEmail() {
        var text = email.value;
        var error = document.getElementById("email_error");
        if (text == null || text.length == 0) {
            error.textContent = "Vui lòng đăng nhập bằng email.";
            error.style.display = "block";
            return false;
        } else if (text.includes("@gmail.com") && text.length < 10) {
            error.textContent = "Email bắt buộc phải là (***@gmail.com)."
            error.style.display = "block";
            return false;
        } else {
            error.style.display = "none";
            return true;
        }
    }

    function validatePass() {
        var text = password.value;
        var error = document.getElementById("password_error");
        if (text.length == 0 || text == null) {
            error.textContent = "Vui lòng điền mật khẩu";
            error.style.display = "block";
            return false;
        } else {
            error.style.display = "none";
            return true;
        }
    }

    email.addEventListener("blur", validateEmail);
    password.addEventListener("blur", validatePass);

    var signIn = document.getElementById("signIn");
    signIn.addEventListener("click", function (event) {
        var isEmailValid = validateEmail();
        var isPasswordValid = validatePass();

        if (!isEmailValid    || !isPasswordValid) {
            event.preventDefault();
        }
    });

</script>

</html>
