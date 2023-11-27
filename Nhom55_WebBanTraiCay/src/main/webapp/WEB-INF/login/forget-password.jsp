<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 18/11/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <%@ page isELIgnored="false" %>
  <title>Quên mật khẩu</title>
  <!-- custom-theme -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="keywords" content="Elegant Login Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
  function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!-- //custom-theme  -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login-css/style.css">
  <!-- font-awesome icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login-css/font-awesome.css">
  <!-- //font-awesome icons -->
  <!-- //font-awesome icons -->
  <link href="//fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
</head>
<body>
<div class="login-form w3_form">
  <!--  Title-->
  <div class="login-title w3_title" >



  </div>
  <div class="login w3_login">
    <h2 class="login-header w3_header">Quên mật khẩu</h2>
    <div class="w3l_grid">
      <form class="login-container" action="#" method="post">
        <input type="email" placeholder="email" Name="email" required="" >
        <input type="submit" value="Gửi lại mật khẩu">
        <c:if test="${not empty result}" >
          <p style="color: red;padding: 10px; text-align: center"> ${result}</p>
        </c:if>
      </form>
    </div>
  </div>

</div>
<div class="footer-w3l">

</div>
</body>
</html>
