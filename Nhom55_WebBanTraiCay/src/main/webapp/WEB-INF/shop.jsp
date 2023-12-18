

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <title>Cửa hàng trái cây</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
          rel="stylesheet">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/animate.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/owl.carousel.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/owl.theme.default.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/magnific-popup.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/aos.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/ionicons.min.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/bootstrap-datepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/jquery.timepicker.css">


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/web-css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/icomoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/fix.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/shop.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/toast.css">


</head>
<body class="goto-here">
<nav class="navbar-container navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
     id="ftco-navbar">
    <div class="container navbar-container">
        <div class="navbar-brand">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Cửa Hàng Trái
                Cây</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="nav-bar-link" id="ftco-nav">
            <ul class="navbar-nav">
                <li class="nav-item active"><a href="${pageContext.request.contextPath}/home"
                                               class="nav-link">Trang Chủ</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Mua Hàng</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath}/ShopForward">Cửa
                            hàng</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/wishlist">Danh
                            sách yêu thích</a>

                        <a class="dropdown-item" href="${pageContext.request.contextPath}/checkout">Thủ
                            tục thanh toán</a>
                    </div>
                </li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/about"
                                        class="nav-link">Về Chúng Tôi</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/contact"
                                        class="nav-link">Liên Hệ</a></li>
                <li class="nav-item cta cta-colored"><a
                        href="${pageContext.request.contextPath}/cart" class="nav-link"><span
                        class="icon-shopping_cart"></span>[${cart.getTotal()}]</a></li>

            </ul>
        </div>

        <div class="navbar-account">
            <c:choose>
                <c:when test="${not empty loginedUser}">
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown05"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <b>${loginedUser.getUsername()}</b>
                        </a>
                        <div class="dropdown-menu account-menu" aria-labelledby="dropdown04">
                            <a class="account dropdown-item" href="user/user-profile.jsp">
                                <svg xmlns="http://www.w3.org/2000/svg" height="1em"
                                     viewBox="0 0 448 512">
                                    <path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"/>
                                </svg>
                                Thông tin
                            </a>
                            <a class="account dropdown-item"
                               href="${pageContext.request.contextPath}/logout">
                                <svg xmlns="http://www.w3.org/2000/svg" height="1em"
                                     viewBox="0 0 512 512">
                                    <path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"/>
                                </svg>
                                Đăng Xuất
                            </a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="login-user">
                        <a class="account" href="${pageContext.request.contextPath}/login">
                            <svg xmlns="http://www.w3.org/2000/svg" height="1em"
                                 viewBox="0 0 512 512">
                                <path d="M217.9 105.9L340.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L217.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1L32 320c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM352 416l64 0c17.7 0 32-14.3 32-32l0-256c0-17.7-14.3-32-32-32l-64 0c-17.7 0-32-14.3-32-32s14.3-32 32-32l64 0c53 0 96 43 96 96l0 256c0 53-43 96-96 96l-64 0c-17.7 0-32-14.3-32-32s14.3-32 32-32z"/>
                            </svg>
                            Đăng Nhập
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
<!-- END nav -->

<div class="hero-wrap hero-bread"
     style="background-image: url('/static/images/bg1.jpg');filter: brightness(0.8);">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">

                <h1 class="mb-0 bread">Các sản phẩm</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10 mb-5 text-center">



                <!--                <ul class="product-category">-->
                <!--                    <li><a href="#" class="active">All</a></li>-->
                <!--                    <li><a href="#">Vegetables</a></li>-->
                <!--                    <li><a href="#">Fruits</a></li>-->
                <!--                    <li><a href="#">Juice</a></li>-->
                <!--                    <li><a href="#">Dried</a></li>-->
                <!--                </ul> -->

                <!--                    <div class="box">-->
                <!--                        <form action ="#">-->
                <!--                            <div class="input_box">-->
                <!--                                <input type="text" placeholder="Search for fruits..." required>-->
                <!--                                <div class="selection"><p>All</p><span></span></div>-->

                <!--                                <div class ="categories">-->
                <!--                                    <p class="option">1</p>-->
                <!--                                    <p class="option">2</p>-->
                <!--                                    <p class="option">3</p>-->
                <!--                                    <p class="option">4</p>-->

                <!--                                </div>-->

                <!--                            </div>-->
                <!--                        </form>-->
                <!--                    </div>-->









                <!--                <ul class="nav nav-pills mb-3 product-category" id="pills-tab" role="tablist">-->
                <!--                    <li class="nav-item " role="presentation">-->
                <!--                        <button class="nav-link" style="outline: 0!important;" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true" fdprocessedid="pda0gw" >All</button>-->
                <!--                    </li>-->
                <!--                    <li class="nav-item" role="presentation">-->
                <!--                        <button class="nav-link active" style="outline: 0!important;" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false" tabindex="-1">Vegetables</button>-->
                <!--                    </li>-->

                <!--                    <li class="nav-item" role="presentation">-->
                <!--                        <button class="nav-link" style="outline: 0!important;" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false" tabindex="-1">Fruits</button>-->
                <!--                    </li>-->
                <!--                    <li class="nav-item" role="presentation">-->
                <!--                        <button class="nav-link" style="outline: 0!important;" id="pills-Juice-tab" data-bs-toggle="pill" data-bs-target="#pills-Juice" type="button" role="tab" aria-controls="pills-Juice" aria-selected="false" tabindex="-1">Juice</button>-->
                <!--                    </li>-->
                <!--                    <li class="nav-item" role="presentation">-->
                <!--                        <button class="nav-link" style="outline: 0!important;" id="pills-Dried-tab" data-bs-toggle="pill" data-bs-target="#pills-Dried" type="button" role="tab" aria-controls="pills-Dried" aria-selected="false" fdprocessedid="x9oioe" tabindex="-1">Dried</button>-->
                <!--                    </li>-->
                <!--                </ul>-->



                <div class="tab-content" id="pills-tabContent">
                    <form style="position: relative; top:-40px; left: 350px" action="ShopController?index=1" method="post">
                        <input style="width: 300px" type="text" placeholder="Tìm trái cây mà bạn cần" name="txtSearch" >
                        <input style="width: 100px" type="submit"  value="Tìm kiếm">
                    </form>
                    <form action="">
                        <!-- Icon Filter -->
                        <div style="position: absolute; top: -45px;left: 570px" class="filter-icon" onclick="toggleFilter()">
                            <svg xmlns="http://www.w3.org/2000/svg" height="16" width="16" viewBox="0 0 512 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2023 Fonticons, Inc.--><path d="M3.9 54.9C10.5 40.9 24.5 32 40 32H472c15.5 0 29.5 8.9 36.1 22.9s4.6 30.5-5.2 42.5L320 320.9V448c0 12.1-6.8 23.2-17.7 28.6s-23.8 4.3-33.5-3l-64-48c-8.1-6-12.8-15.5-12.8-25.6V320.9L9 97.3C-.7 85.4-2.8 68.8 3.9 54.9z"/></svg>
                        </div>

                        <!-- Dropdown Filter -->
                        <div style="top: -30px;left: 250px" id="filterDropdown" class="filter-dropdown">
                            <a href="FilterForAllProduct?sortBy=price&order=asc&pageId=1" >Sắp xếp giá tăng dần</a>
                            <a href="FilterForAllProduct?sortBy=price&order=desc&pageId=1" >Sắp xếp giá giảm dần</a>
                            <a href="FilterForAllProduct?sortBy=nameOfProduct&order=asc&pageId=1" >Sắp xếp theo tên từ  A-Z</a>
                            <a href="FilterForAllProduct?sortBy=nameOfProduct&order=desc&pageId=1" >Sắp xếp theo tên từ  Z-A</a>
                            <a href="FilterForAllProduct?sortBy=dateOfImporting&order=desc&pageId=1" >Sắp xếp theo ngày nhập kho mới nhất</a>
                        </div>
                    </form>


                    <div class="tab-pane fade active show" id="pills-profile" role="tabpanel"
                         aria-labelledby="pills-profile-tab" tabindex="0">
                        <div class="row">

                            <c:forEach items="${listOfProduct}" var="product">
                                <div class="col-md-6 col-lg-3 ftco-animate fadeInUp ftco-animated">
                                    <div class="product">
                                        <a href="" class="img-prod"><img
                                                style="width: 205px; height: 164px; object-fit: cover"
                                                class="img-fluid"
                                                src="static/images/${product.getImg()}"
                                                alt="Colorlib Template">
                                        </a>
                                        <div class="text py-3 pb-4 px-3 text-center">
                                            <h3><a href="">${product.getNameOfProduct()} </a></h3>
                                            <div class="d-flex">
                                                <div class="pricing">
                                                    <p class="price"><span
                                                            class="price">${product.getPrice()} VNĐ</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="bottom-area d-flex px-3">
                                                <div class="m-auto d-flex">
                                                    <a href="productDetails?id=${product.getId()}"
                                                       class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                                        <span><i class="ion-ios-menu"></i></span>
                                                    </a>
                                                    <a href="add-cart?id=${product.getId()}"
                                                       class="buy-now d-flex justify-content-center align-items-center mx-1">
                                                        <span><i class="ion-ios-cart"></i></span>
                                                    </a>
                                                    <a href="#"
                                                       class="heart d-flex justify-content-center align-items-center ">
                                                        <span><i class="ion-ios-heart"></i></span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                    </div>
                </div>

            </div>

            <div class="row mt-5">
                <div class="col text-center">
                    <div style="min-width: 350px" class="block-27">
                        <ul>
<%--    Trường hợp tìm ra số sản phẩm chỉ có trong 1 trang thì 2 nút <,> ko được xài--%>
                            <c:if test="${pageId== 1 && haveMaxPage ==1}">
                                <li><a >&lt;</a></li>
                                <c:forEach begin="1" end="${haveMaxPage}" var= "i">
                                    <li id="${i}" ><a href="ShopForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a></li>
                                </c:forEach>
                                <li><a >></a></li>
                            </c:if>

                             <c:if test="${ haveMaxPage !=1}">
        <%-- Trường hợp đang ở trang 1 thì chỉ ko được xài nút <--%>
                             <c:if test="${pageId ==1}" >
                                 <li><a >&lt;</a></li>
                                 <c:forEach begin="1" end="${haveMaxPage}" var= "i">
                                <li id="${i}" ><a  href="ShopForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a></li>
                                 </c:forEach>
                                  <li><a href="ShopForward?pageId=${pageId+1}&sortBy=${sortBy}&order=${order}">&gt;</a></li>
                               </c:if>

        <%--  Còn trường hợp này nút nào cũng xài được--%>
                              <c:if test="${pageId >1 && pageId<haveMaxPage}" >
                                  <li><a href="ShopForward?pageId=${pageId-1}&sortBy=${sortBy}&order=${order}">&lt;</a></li>
                                 <c:forEach begin="1" end="${haveMaxPage}" var= "i">
                                 <li id="${i}" ><a  href="ShopForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a></li>
                                 </c:forEach>
                                  <li><a href="ShopForward?pageId=${pageId+1}&sortBy=${sortBy}&order=${order}">&gt;</a></li>
                              </c:if>
        <%-- Trường hợp đang ở trang cuối thì chỉ ko được xài nút >--%>

                                 <c:if test="${pageId ==haveMaxPage}" >
                                 <li><a href="ShopForward?pageId=${pageId-1}&sortBy=${sortBy}&order=${order}">&lt;</a></li>
                                 <c:forEach begin="1" end="${haveMaxPage}" var= "i">
                                  <li id="${i}" ><a  href="ShopForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a></li>
                                 </c:forEach>
                                <li><a>></a></li>
                                 </c:if>

                             </c:if>



                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>

</section>

<!--Theo dõi tin tức-->

<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
    <div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
            <div class="col-md-6">
                <h2 style="font-size: 22px;" class="mb-0">Theo dõi bản tin của chúng tôi</h2>
                <span>Hãy đăng ký bằng email để biết thêm về các cửa hàng mới nhất và ưu đãi đặc biệt của chúng tôi</span>
            </div>
            <div class="col-md-6 d-flex align-items-center">
                <form action="#" class="subscribe-form">
                    <div class="form-group d-flex">
                        <input type="text" class="form-control" placeholder="Nhập email tại đây">
                        <input type="submit" value="Đăng ký" class="submit px-3">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!--Theo dõi tin tức-->


<footer class="ftco-footer ftco-section">
    <div class="container">
        <div class="row">
            <div class="mouse">
                <a href="#" class="mouse-icon">
                    <div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
                </a>
            </div>
        </div>
        <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Trái cây tươi ngon</h2>
                    <p>Trúc xinh trúc mọc đầu đình, ai quen mua hoa quả lại càng thêm xinh.</p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4 ml-md-5">
                    <h2 class="ftco-heading-2">Menu</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">Cửa hàng chúng tôi</a></li>
                        <li><a href="#" class="py-2 d-block">Về chúng tôi</a></li>
                        <li><a href="#" class="py-2 d-block">Liên hệ với chúng tôi</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Help</h2>
                    <div class="d-flex">
                        <ul class="list-unstyled mr-l-5 pr-l-3 mr-4">
                            <li><a href="#" class="py-2 d-block">Thông tin vận chuyển</a></li>
                            <li><a href="#" class="py-2 d-block">Hoàn trả và đổi sản phẩm</a></li>
                            <li><a href="#" class="py-2 d-block">Điều khoản và điều kiện</a></li>
                            <li><a href="#" class="py-2 d-block">Chính sách bảo mật</a></li>
                        </ul>
                        <ul class="list-unstyled">
                            <li><a href="#" class="py-2 d-block">
                                Câu hỏi thường gặp</a></li>
                            <li><a href="#" class="py-2 d-block">Liên hệ</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Bạn có câu hỏi với chúng tôi ?</h2>
                    <div class="block-23 mb-3">
                        <ul>
                            <li><span class="icon icon-map-marker"></span><span class="text">Trường Đại Học Nông Lâm Thành Phố Hồ Chí Minh, Khu phố 6, Phường Linh Trung, TP. Thủ Đức, TP. Hồ Chí Minh</span>
                            </li>
                            <li><a href="#"><span class="icon icon-phone"></span><span
                                    class="text">028-38966780</span></a></li>
                            <li><a href="#"><span class="icon icon-envelope"></span><span
                                    class="text">pdaotao@hcmuaf.edu.vn</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">

                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    All rights reserved | Mẫu thiết kế của <i class="icon-heart color-danger"
                                                              aria-hidden="true"></i>  <a
                            href="https://colorlib.com" target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
            </div>
        </div>
    </div>
</footer>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>
<%--Script xuất hiện bảng cho filter--%>
<script>
  document.getElementById('${pageId}').classList.add("active")

  function toggleFilter() {
    var dropdown = document.getElementById("filterDropdown");
    dropdown.style.display = (dropdown.style.display === "block") ? "none" : "block";
  }
</script>

<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-migrate-3.0.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.easing.1.3.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.stellar.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/aos.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.animateNumber.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/static/js/scrollax.min.js"></script>
<script src="${pageContext.request.contextPath}/https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="${pageContext.request.contextPath}/static/js/google-map.js"></script>
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>
<script src="${pageContext.request.contextPath}/https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

</body>
</html>