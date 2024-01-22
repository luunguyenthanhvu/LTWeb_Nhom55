<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 22/01/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/style_main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/fix.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/shop_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web-css/toast_style.css">
</head>
<body class="goto-here">
<nav class="navbar-container navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
     id="ftco-navbar">
    <div class="container navbar-container">
        <div class="navbar-brand">
            <a class="navbar-brand" href="index.html">Cửa Hàng Trái Cây</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="nav-bar-link" id="ftco-nav">
            <ul class="navbar-nav">
                <li class="nav-item active"><a href="index.html" class="nav-link">Trang Chủ</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Mua Hàng</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="shop.html">Cửa hàng</a>
                        <a class="dropdown-item" href="wishlist.html">Danh sách yêu thích</a>

                        <a class="dropdown-item" href="checkout.html">Thủ tục thanh toán</a>
                    </div>
                </li>
                <li class="nav-item"><a href="about.jsp" class="nav-link">Về Chúng Tôi</a></li>
                <li class="nav-item"><a href="contact.html" class="nav-link">Liên Hệ</a></li>
                <li class="nav-item cta cta-colored"><a href="cart.jsp" class="nav-link"><span
                        class="icon-shopping_cart"></span>[0]</a></li>

            </ul>
        </div>
        <div class="navbar-account">
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Thông tin người dùng</a>
                <div class="dropdown-menu account-menu" aria-labelledby="dropdown04">
                    <a class="account dropdown-item" href="user/user-profile.jsp">
                        <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                            <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                            <path d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"/>
                        </svg>
                        Người Dùng
                    </a>
                    <a class="account dropdown-item" href="login/login.html">
                        <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
                            <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                            <path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"/>
                        </svg>
                        Đăng Xuất
                    </a>
                </div>
            </div>
            <!--            <div class="login-user">-->
            <!--                <a class="account" href="#">-->
            <!--                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">&lt;!&ndash;! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. &ndash;&gt;<path d="M217.9 105.9L340.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L217.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1L32 320c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM352 416l64 0c17.7 0 32-14.3 32-32l0-256c0-17.7-14.3-32-32-32l-64 0c-17.7 0-32-14.3-32-32s14.3-32 32-32l64 0c53 0 96 43 96 96l0 256c0 53-43 96-96 96l-64 0c-17.7 0-32-14.3-32-32s14.3-32 32-32z"/></svg>-->
            <!--                    Login-->
            <!--                </a>-->
            <!--            </div>-->
        </div>
    </div>
</nav>
<!-- END nav -->

<div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span>
                    <span>Wishlist</span></p>
                <h1 class="mb-0 bread">My Wishlist</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>&nbsp;</th>
                            <th>Danh sách</th>
                            <th>Mô tả</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng</th>
                            <!--                            cột thêm sản phẩm-->
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="text-center">
                            <td class="product-remove"><a href="#"><span
                                    class="ion-ios-close"></span></a></td>

                            <td class="image-prod">
                                <div class="img"
                                     style="background-image:url(images/chuoi_cau.png) ;width: 100px;height: 100px;"></div>
                            </td>

                            <td class="product-name">
                                <h3>Chuối Cau</h3>
                                <p>Chuối cau có quả nhỏ, hướng tròn, mập giống hình quả cau. Một cây
                                    chuối cau có khả năng cho ra rất nhiều quả, năng suất cao nên bà
                                    con nông dân ở miền Trung và miền Nam hoặc khu vực có đồi núi ưa
                                    trồng.</p>
                            </td>

                            <td class="price">40.000 đ</td>

                            <td class="quantity">
                                <div class="input-group mb-3">
                                    <input type="text" name="quantity"
                                           class="quantity form-control input-number"
                                           value="1" min="1" max="100">
                                </div>
                            </td>

                            <td class="total">40.000 đ</td>
                        </tr><!-- END TR-->

                        <tr class="text-center">
                            <td class="product-remove"><a href="#"><span
                                    class="ion-ios-close"></span></a></td>

                            <td class="image-prod">
                                <div class="img"
                                     style="background-image:url(images/dau.jpg);"></div>
                            </td>

                            <td class="product-name">
                                <h3>Dâu</h3>
                                <p>Dâu tây thơm, quả đều , mọng nước </p>
                            </td>

                            <td class="price">40.000 đ</td>

                            <td class="quantity">
                                <div class="input-group mb-3">
                                    <input type="text" name="quantity"
                                           class="quantity form-control input-number"
                                           value="1" min="1" max="100">
                                </div>
                            </td>

                            <td class="total">40.000 đ</td>
                        </tr><!-- END TR-->

                        <tr class="text-center">
                            <td class="product-remove"><a href="#"><span
                                    class="ion-ios-close"></span></a></td>

                            <td class="image-prod">
                                <div class="img"
                                     style="background-image:url(images/chuoi_tieu.png);width: 100px;height: 100px;"></div>
                            </td>

                            <td class="product-name">
                                <h3>Chuối Tiêu</h3>
                                <p>Quả chuối tiêu có hình dáng cong như lưỡi liềm, chưa chín có màu
                                    xanh đậm, chín thì chuyển sang màu vàng, phần thịt vàng nõn, rất
                                    thơm và ngọt.</p>
                            </td>

                            <td class="price">12.000 đ</td>

                            <td class="quantity">
                                <div class="input-group mb-3">
                                    <input type="text" name="quantity"
                                           class="quantity form-control input-number"
                                           value="1" min="1" max="100">
                                </div>
                            </td>

                            <td class="total">12.000 đ</td>
                        </tr><!-- END TR-->

                        <tr class="text-center">
                            <td class="product-remove"><a href="#"><span
                                    class="ion-ios-close"></span></a></td>

                            <td class="image-prod">
                                <div class="img" style="background-image:url(images/oi.jpg);"></div>
                            </td>

                            <td class="product-name">
                                <h3>Ổi</h3>
                                <p>Quả chín có vị chua ngọt hay ngọt và có mùi thơm đặc trưng, có
                                    thể ăn tươi, làm mứt hay làm nước giải khát.</p>
                            </td>

                            <td class="price">30.000 đ</td>

                            <td class="quantity">
                                <div class="input-group mb-3">
                                    <input type="text" name="quantity"
                                           class="quantity form-control input-number"
                                           value="1" min="1" max="100">
                                </div>
                            </td>

                            <td class="total">30.000đ</td>
                        </tr><!-- END TR-->

                        <tr class="text-center">
                            <td class="product-remove"><a href="#"><span
                                    class="ion-ios-close"></span></a></td>

                            <td class="image-prod">
                                <div class="img"
                                     style="background-image:url(images/chom_chom.jpg);"></div>
                            </td>

                            <td class="product-name">
                                <h3>Chôm Chôm</h3>
                                <p> Phần thịt bên trong mềm bao bọc hạt, màu trắng nhạt và có vị
                                    ngọt, hơi chua nhẹ.</p>
                            </td>

                            <td class="price">50.000 đ</td>

                            <td class="quantity">
                                <div class="input-group mb-3">
                                    <input type="text" name="quantity"
                                           class="quantity form-control input-number"
                                           value="1" min="1" max="100">
                                </div>
                            </td>

                            <td class="total">50.000 đ</td>
                        </tr><!-- END TR-->

                        <tr class="text-center">
                            <td class="product-remove"><a href="#"><span
                                    class="ion-ios-close"></span></a></td>

                            <td class="image-prod">
                                <div class="img"
                                     style="background-image:url(images/xoai.png);width: 100px;height: 100px;"></div>
                            </td>

                            <td class="product-name">
                                <h3>Xoài</h3>
                                <p>Quả xoài chín có màu vàng hấp dẫn, có vị chua ngọt, mùi thơm ngon
                                    được nhiều người ưa thích và được xem là một loại quả quí.</p>
                            </td>

                            <td class="price">40.000 đ</td>

                            <td class="quantity">
                                <div class="input-group mb-3">
                                    <input type="text" name="quantity"
                                           class="quantity form-control input-number"
                                           value="1" min="1" max="100">
                                </div>
                            </td>

                            <td class="total">40.000 đ</td>
                        </tr><!-- END TR-->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
    <div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
            <div class="col-md-6">
                <h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>
                <span>Get e-mail updates about our latest shops and special offers</span>
            </div>
            <div class="col-md-6 d-flex align-items-center">
                <form action="#" class="subscribe-form">
                    <div class="form-group d-flex">
                        <input type="text" class="form-control" placeholder="Enter email address">
                        <input type="submit" value="Subscribe" class="submit px-3">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
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
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a>
                        </li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a>
                        </li>
                        <li class="ftco-animate"><a href="#"><span
                                class="icon-instagram"></span></a></li>
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

                <p>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    All rights reserved | Mẫu thiết kế của <i class="icon-heart color-danger"
                                                              aria-hidden="true"></i> <a
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
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4"
                stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4"
                stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>

<script src="${pageContext.request.contextPath}/static/js/web-js/index.js"></script>
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
<script>
  $(document).ready(function () {

    var quantitiy = 0;
    $('.quantity-right-plus').click(function (e) {

      // Stop acting like a button
      e.preventDefault();
      // Get the field name
      var quantity = parseInt($('#quantity').val());

      // If is not undefined

      $('#quantity').val(quantity + 1);

      // Increment

    });

    $('.quantity-left-minus').click(function (e) {
      // Stop acting like a button
      e.preventDefault();
      // Get the field name
      var quantity = parseInt($('#quantity').val());

      // If is not undefined

      // Increment
      if (quantity > 0) {
        $('#quantity').val(quantity - 1);
      }
    });

  });
</script>

</body>
</html>
