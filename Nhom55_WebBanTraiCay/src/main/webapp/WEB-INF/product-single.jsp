
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="static/css/web-css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="static/css/web-css/animate.css">

    <link rel="stylesheet" href="static/css/web-css/owl.carousel.min.css">
    <link rel="stylesheet" href="static/css/web-css/owl.theme.default.min.css">
    <link rel="stylesheet" href="static/css/web-css/magnific-popup.css">

    <link rel="stylesheet" href="static/css/web-css/aos.css">

    <link rel="stylesheet" href="static/css/web-css/ionicons.min.css">

    <link rel="stylesheet" href="static/css/web-css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="static/css/web-css/jquery.timepicker.css">


    <link rel="stylesheet" href="static/css/web-css/flaticon.css">
    <link rel="stylesheet" href="static/css/web-css/icomoon.css">
    <link rel="stylesheet" type="text/css" href="static/css/web-css/style.css">
    <link rel="stylesheet" href="static/css/web-css/fix.css">






</head>
<body class="goto-here">
<nav class="navbar-container navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container navbar-container">
        <div class="navbar-brand">
            <a class="navbar-brand" href="index.html">Cửa Hàng Trái Cây</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="nav-bar-link" id="ftco-nav">Chi tiết trái cây</h1>
            </div>
        </div>
    </div>
</div>

</nav>


    <section id="home-section" class="hero">
        <div class="home-slider owl-carousel">
            <div class="slider-item" style="background-image: url(static/images/bg1.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

                    </div>
                </div>
            </div>


        </div>
    </section>



<section class="ftco-section">
    <div class="container">
        <div class="row">


<%--            <c:if test="${not empty showProduct}" var="product">--%>
                <c:set var="product" value="${requestScope.showProduct}"/>
            <div class="col-lg-6 mb-5 ftco-animate">
                <a href="" class="image-popup"><img src="static/images/${product.getImg()}" class="img-fluid"
                                                                                alt="Colorlib Template"></a>
            </div>
            <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                <h3>${product.getNameOfProduct()}</h3>
                <div class="rating d-flex">
                    <p class="text-left mr-4">
                        <a href="#" class="mr-2">5.0</a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                        <a href="#"><span class="ion-ios-star-outline"></span></a>
                    </p>
                    <p class="text-left mr-4">
                        <a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">Rating</span></a>
                    </p>
                    <p class="text-left">
                        <a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
                    </p>
                </div>


                <p class="price"><span>${product.getPrice()} VNĐ/ ${product.getWeightDefault()} kg</span></p>

                <p>${product.getDescription()}</p>
                <div class="row mt-4">
                    <div class="w-100"></div>
                    <div class="input-group col-md-6 d-flex mb-3">
	             	<span class="input-group-btn mr-2">
	                	<button type="button" class="quantity-left-minus btn" data-type="minus" data-field="">
	                   <i class="ion-ios-remove"></i>
	                	</button>
	            		</span>
                        <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1"
                               min="1" max="100">
                        <span class="input-group-btn ml-2">
	                	<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
	                     <i class="ion-ios-add"></i>
	                 </button>
	             	</span>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-md-12">
                        <p style="color: #000;">${product.getWeight()} kg hợp lệ</p>
                    </div>
                </div>
                <p><a href="cart.html" class="btn btn-black py-3 px-5">Thêm vào giỏ hàng</a></p>
            </div>
<%--            </c:if>--%>


            <c:if test="${empty showProduct}">
                <p>Không tìm thấy sản phẩm hoặc ID không hợp lệ.</p>
            </c:if>

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
                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">pdaotao@hcmuaf.edu.vn</span></a>
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


<script src="static/js/jquery.min.js"></script>
<script src="static/js/jquery-migrate-3.0.1.min.js"></script>
<script src="static/js/popper.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/jquery.easing.1.3.js"></script>
<script src="static/js/jquery.waypoints.min.js"></script>
<script src="static/js/jquery.stellar.min.js"></script>
<script src="static/js/owl.carousel.min.js"></script>
<script src="static/js/jquery.magnific-popup.min.js"></script>
<script src="static/js/aos.js"></script>
<script src="static/js/jquery.animateNumber.min.js"></script>
<script src="static/js/bootstrap-datepicker.js"></script>
<script src="static/js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="static/js/google-map.js"></script>
<script src="static/js/main.js"></script>

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