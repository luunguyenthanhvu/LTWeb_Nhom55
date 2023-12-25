<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Coding by CodingNepal | www.codingnepalweb.com -->
<html lang="en" dir="ltr" xmlns="http://www.w3.org/1999/html">
<head>
  <%@ page isELIgnored="false" %>
    <meta charset="UTF-8">
    <title> Kết quả tìm kiếm người dùng </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin-css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin-css/dssp.css">

    <!-- Boxiocns CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body onload="myFunction()" style="margin:0;">
<div id="loader"></div>
<div style="display:none;" id="myDiv" class="animate-bottom">
    <div class="sidebar close">
        <div class="logo-details">
            <i>
                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 640 512">
                    <path d="M36.8 192H603.2c20.3 0 36.8-16.5 36.8-36.8c0-7.3-2.2-14.4-6.2-20.4L558.2 21.4C549.3 8 534.4 0 518.3 0H121.7c-16 0-31 8-39.9 21.4L6.2 134.7c-4 6.1-6.2 13.2-6.2 20.4C0 175.5 16.5 192 36.8 192zM64 224V384v80c0 26.5 21.5 48 48 48H336c26.5 0 48-21.5 48-48V384 224H320V384H128V224H64zm448 0V480c0 17.7 14.3 32 32 32s32-14.3 32-32V224H512z"/>
                </svg>
            </i>
            <span class="logo_name">Quản trị viên</span>
        </div>
        <ul class="nav-links">
            <li>
                <div class="iocn-link">
                    <a href="#">
                        <i>
                            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
                                <path d="M406.5 399.6C387.4 352.9 341.5 320 288 320H224c-53.5 0-99.4 32.9-118.5 79.6C69.9 362.2 48 311.7 48 256C48 141.1 141.1 48 256 48s208 93.1 208 208c0 55.7-21.9 106.2-57.5 143.6zm-40.1 32.7C334.4 452.4 296.6 464 256 464s-78.4-11.6-110.5-31.7c7.3-36.7 39.7-64.3 78.5-64.3h64c38.8 0 71.2 27.6 78.5 64.3zM256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zm0-272a40 40 0 1 1 0-80 40 40 0 1 1 0 80zm-88-40a88 88 0 1 0 176 0 88 88 0 1 0 -176 0z"/>
                            </svg>
                        </i>
                        <span class="link_name">Tài khoản</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
                    <li><a class="link_name" href="#">Tài khoản</a></li>
                    <li><a href="admin-profile.html">Thông tin tài khoản</a></li>
                    <li><a href="update-admin-password.jsp">Đổi mật khẩu</a></li>
                </ul>
            </li>
            <li>
                <div class="iocn-link">
                    <a href="#">
                        <i>
                            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
                                <path d="M121 32C91.6 32 66 52 58.9 80.5L1.9 308.4C.6 313.5 0 318.7 0 323.9V416c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V323.9c0-5.2-.6-10.4-1.9-15.5l-57-227.9C446 52 420.4 32 391 32H121zm0 64H391l48 192H387.8c-12.1 0-23.2 6.8-28.6 17.7l-14.3 28.6c-5.4 10.8-16.5 17.7-28.6 17.7H195.8c-12.1 0-23.2-6.8-28.6-17.7l-14.3-28.6c-5.4-10.8-16.5-17.7-28.6-17.7H73L121 96z"/>
                            </svg>
                        </i>
                        <span class="link_name">Sản phẩm</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
                    <li><a class="link_name" href="#">Chức năng</a></li>
                    <li><a href="product-list.html">Danh sách sản phẩm</a></li>

                    <li><a href="add-product.html">Thêm sản phẩm</a></li>
                    <li><a href="time-expired-product.html">Sản phẩm hết hạn</a></li>
                </ul>
            </li>
            <li>
                <div class="iocn-link">
                    <a href="#">
                        <i>
                            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512">
                                <path d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"/>
                            </svg>
                        </i>
                        <span class="link_name">Đơn hàng</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
                    <li><a class="link_name" href="#">Đơn hàng</a></li>
                    <li><a href="order-list.html">Quản lý đơn hàng</a></li>
                </ul>
            </li>
            <li>
                <div class="iocn-link">
                    <a href="#">
                        <i>
                            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                                <path d="M160 80c0-26.5 21.5-48 48-48h32c26.5 0 48 21.5 48 48V432c0 26.5-21.5 48-48 48H208c-26.5 0-48-21.5-48-48V80zM0 272c0-26.5 21.5-48 48-48H80c26.5 0 48 21.5 48 48V432c0 26.5-21.5 48-48 48H48c-26.5 0-48-21.5-48-48V272zM368 96h32c26.5 0 48 21.5 48 48V432c0 26.5-21.5 48-48 48H368c-26.5 0-48-21.5-48-48V144c0-26.5 21.5-48 48-48z"/>
                            </svg>
                        </i>
                        <span class="link_name">Doanh thu</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
                    <li><a class="link_name" href="#">Doanh thu</a></li>
                    <li><a href="manage-sale.html"> Doanh số sản phẩm</a></li>
                    <li><a href="see-each-product-bought-in-a-month.html">Chi tiết</a></li>
                </ul>
            </li>
            <li>
                <div class="iocn-link">
                    <a href="#">
                        <i>
                            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 640 512">
                                <path d="M144 160A80 80 0 1 0 144 0a80 80 0 1 0 0 160zm368 0A80 80 0 1 0 512 0a80 80 0 1 0 0 160zM0 298.7C0 310.4 9.6 320 21.3 320H234.7c.2 0 .4 0 .7 0c-26.6-23.5-43.3-57.8-43.3-96c0-7.6 .7-15 1.9-22.3c-13.6-6.3-28.7-9.7-44.6-9.7H106.7C47.8 192 0 239.8 0 298.7zM320 320c24 0 45.9-8.8 62.7-23.3c2.5-3.7 5.2-7.3 8-10.7c2.7-3.3 5.7-6.1 9-8.3C410 262.3 416 243.9 416 224c0-53-43-96-96-96s-96 43-96 96s43 96 96 96zm65.4 60.2c-10.3-5.9-18.1-16.2-20.8-28.2H261.3C187.7 352 128 411.7 128 485.3c0 14.7 11.9 26.7 26.7 26.7H455.2c-2.1-5.2-3.2-10.9-3.2-16.4v-3c-1.3-.7-2.7-1.5-4-2.3l-2.6 1.5c-16.8 9.7-40.5 8-54.7-9.7c-4.5-5.6-8.6-11.5-12.4-17.6l-.1-.2-.1-.2-2.4-4.1-.1-.2-.1-.2c-3.4-6.2-6.4-12.6-9-19.3c-8.2-21.2 2.2-42.6 19-52.3l2.7-1.5c0-.8 0-1.5 0-2.3s0-1.5 0-2.3l-2.7-1.5zM533.3 192H490.7c-15.9 0-31 3.5-44.6 9.7c1.3 7.2 1.9 14.7 1.9 22.3c0 17.4-3.5 33.9-9.7 49c2.5 .9 4.9 2 7.1 3.3l2.6 1.5c1.3-.8 2.6-1.6 4-2.3v-3c0-19.4 13.3-39.1 35.8-42.6c7.9-1.2 16-1.9 24.2-1.9s16.3 .6 24.2 1.9c22.5 3.5 35.8 23.2 35.8 42.6v3c1.3 .7 2.7 1.5 4 2.3l2.6-1.5c16.8-9.7 40.5-8 54.7 9.7c2.3 2.8 4.5 5.8 6.6 8.7c-2.1-57.1-49-102.7-106.6-102.7zm91.3 163.9c6.3-3.6 9.5-11.1 6.8-18c-2.1-5.5-4.6-10.8-7.4-15.9l-2.3-4c-3.1-5.1-6.5-9.9-10.2-14.5c-4.6-5.7-12.7-6.7-19-3L574.4 311c-8.9-7.6-19.1-13.6-30.4-17.6v-21c0-7.3-4.9-13.8-12.1-14.9c-6.5-1-13.1-1.5-19.9-1.5s-13.4 .5-19.9 1.5c-7.2 1.1-12.1 7.6-12.1 14.9v21c-11.2 4-21.5 10-30.4 17.6l-18.2-10.5c-6.3-3.6-14.4-2.6-19 3c-3.7 4.6-7.1 9.5-10.2 14.6l-2.3 3.9c-2.8 5.1-5.3 10.4-7.4 15.9c-2.6 6.8 .5 14.3 6.8 17.9l18.2 10.5c-1 5.7-1.6 11.6-1.6 17.6s.6 11.9 1.6 17.5l-18.2 10.5c-6.3 3.6-9.5 11.1-6.8 17.9c2.1 5.5 4.6 10.7 7.4 15.8l2.4 4.1c3 5.1 6.4 9.9 10.1 14.5c4.6 5.7 12.7 6.7 19 3L449.6 457c8.9 7.6 19.2 13.6 30.4 17.6v21c0 7.3 4.9 13.8 12.1 14.9c6.5 1 13.1 1.5 19.9 1.5s13.4-.5 19.9-1.5c7.2-1.1 12.1-7.6 12.1-14.9v-21c11.2-4 21.5-10 30.4-17.6l18.2 10.5c6.3 3.6 14.4 2.6 19-3c3.7-4.6 7.1-9.4 10.1-14.5l2.4-4.2c2.8-5.1 5.3-10.3 7.4-15.8c2.6-6.8-.5-14.3-6.8-17.9l-18.2-10.5c1-5.7 1.6-11.6 1.6-17.5s-.6-11.9-1.6-17.6l18.2-10.5zM472 384a40 40 0 1 1 80 0 40 40 0 1 1 -80 0z"/>
                            </svg>
                        </i>
                        <span class="link_name">Người dùng</span>
                    </a>
                    <i class='bx bxs-chevron-down arrow'></i>
                </div>
                <ul class="sub-menu">
                    <li><a class="link_name" href="#">Người dùng</a></li>
                    <li><a href="#">Danh sách người dùng</a></li>
                </ul>
            </li>

            <li>

                        <div class="profile-details">
                            <div class="profile-content">
                                <img src="${loginedUser.getImg()}" alt="profileImg">
                            </div>
                            <div class="name-job">
                                <div class="profile_name">${(empty adminUpdate) ? loginedUser.getUsername() : adminUpdate.getUsername()}</div>
                                <div class="job">Quản trị viên</div>
                            </div>
                            <a href="${pageContext.request.contextPath}/logout">
                                <i style="transform: rotate(180deg); ">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
                                        <path d="M502.6 278.6c12.5-12.5 12.5-32.8 0-45.3l-128-128c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L402.7 224 192 224c-17.7 0-32 14.3-32 32s14.3 32 32 32l210.7 0-73.4 73.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0l128-128zM160 96c17.7 0 32-14.3 32-32s-14.3-32-32-32L96 32C43 32 0 75 0 128L0 384c0 53 43 96 96 96l64 0c17.7 0 32-14.3 32-32s-14.3-32-32-32l-64 0c-17.7 0-32-14.3-32-32l0-256c0-17.7 14.3-32 32-32l64 0z"/>
                                    </svg>
                                </i>
                            </a>
                        </div>

            </li>
        </ul>
    </div>
    <section class="home-section">
        <div class="home-content">
            <svg class='bx-menu' xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                <path d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z"/>
            </svg>
            <span class="text">Danh sách người dùng</span>
        </div>
        <div class="find-product">
            <form action="listController?index=1" method="post">
                <div class="fill-product">
                    <input id="find-product" type="text" placeholder="Tìm kiếm bằng ID hoặc tên người dùng" name="txtSearch">


                    <div class="filter-icon" onclick="toggleFilter()">
                        <span class="font_bold">Lọc theo</span>
                        <div id="filterDropdown" class="filter-dropdown" style="display: none;">
                            <a href="FilterForAllUser?sortBy=username&amp;order=asc&amp;pageId=1">Tên</a>
                        </div>
                    </div>
                    <input style="width: 100px" type="submit" value="Tìm kiếm">
                </div>
            </form>
        </div>

        <div class="container" style="margin: 30px 30px 0 30px">
            <div class="table-sanpham">

                    <table class="table-sanpham">
                        <tr>
                            <th style="width: 70px;">ID</th>
                            <th style="width: 200px;">Tên người dùng</th>
                            <th style="width: 100px;">Hình ảnh</th>
                            <th style="width: 150px;">Email</th>
                            <th style="width: 150px;">Số điện thoại</th>
                            <th style="width: 200px;">Địa chỉ</th>
                            <th style="width: 100px;">Tình trạng</th>
                            <th style="width: 100px;">Chức năng</th>
                        </tr>
                      <c:forEach items="${listOfUser}" var="user">
                        <tr>
                            <td>${user.getId()}</td>
                            <td>${user.getUsername()}</td>
                            <td class="img-product">
                                <img src="${user.getImg()}">
                            </td>
                            <td>${user.getEmail()}</td>
                            <td>${user.getPhoneNumber()}</td>
                            <td>${user.getAddress()}</td>
                            <td>
                                <c:set var="status" value="${user.getStatus()}" />
                                <c:choose>
                                    <c:when test="${status eq '1'}">
                                        <div class="account">Hoạt động</div>
                                    </c:when>
                                    <c:when test="${status eq '0'}">
                                        <div class="account">Đã khóa</div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="account">Trạng thái khác</div>
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td class="function-product">
                                <a href="updateUser?id=${loginedUser.getId()}">
                                    <svg class="fill-red" xmlns="http://www.w3.org/2000/svg" height="1em"
                                         viewBox="0 0 512 512">
                                        <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                        <path d="M410.3 231l11.3-11.3-33.9-33.9-62.1-62.1L291.7 89.8l-11.3 11.3-22.6 22.6L58.6 322.9c-10.4 10.4-18 23.3-22.2 37.4L1 480.7c-2.5 8.4-.2 17.5 6.1 23.7s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L387.7 253.7 410.3 231zM160 399.4l-9.1 22.7c-4 3.1-8.5 5.4-13.3 6.9L59.4 452l23-78.1c1.4-4.9 3.8-9.4 6.9-13.3l22.7-9.1v32c0 8.8 7.2 16 16 16h32zM362.7 18.7L348.3 33.2 325.7 55.8 314.3 67.1l33.9 33.9 62.1 62.1 33.9 33.9 11.3-11.3 22.6-22.6 14.5-14.5c25-25 25-65.5 0-90.5L453.3 18.7c-25-25-65.5-25-90.5 0zm-47.4 168l-144 144c-6.2 6.2-16.4 6.2-22.6 0s-6.2-16.4 0-22.6l144-144c6.2-6.2 16.4-6.2 22.6 0s6.2 16.4 0 22.6z"/>
                                    </svg>
                                </a>
                                <a href="">
                                    <svg class="fill-black" xmlns="http://www.w3.org/2000/svg" height="1em"
                                         viewBox="0 0 448 512">
                                        <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
                                        <path d="M135.2 17.7L128 32H32C14.3 32 0 46.3 0 64S14.3 96 32 96H416c17.7 0 32-14.3 32-32s-14.3-32-32-32H320l-7.2-14.3C307.4 6.8 296.3 0 284.2 0H163.8c-12.1 0-23.2 6.8-28.6 17.7zM416 128H32L53.2 467c1.6 25.3 22.6 45 47.9 45H346.9c25.3 0 46.3-19.7 47.9-45L416 128z"/>
                                    </svg>
                                </a>
                            </td>
                        </tr>
                      </c:forEach>

                    </table>
            </div>

            <div class="pagination">
                <ul class="pagination-list">
                            <%--    Trường hợp tìm ra số người dùng chỉ có trong 1 trang thì 2 nút <,> ko được xài--%>
                            <c:if test="${pageId== 1 && haveMaxPage ==1}">
                                <li><a>&lt;</a></li>
                                <c:forEach begin="1" end="${haveMaxPage}" var="i">
                                    <li id="${i}"><a
                                            href="listUserForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a>
                                    </li>
                                </c:forEach>
                                <li><a>></a></li>
                            </c:if>

                            <c:if test="${ haveMaxPage !=1}">
                                <%-- Trường hợp đang ở trang 1 thì chỉ ko được xài nút <--%>
                                <c:if test="${pageId ==1}">
                                    <li><a>&lt;</a></li>
                                    <c:forEach begin="1" end="${haveMaxPage}" var="i">
                                        <li id="${i}"><a
                                                href="listUserForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li><a href="listUserForward?pageId=${pageId+1}&sortBy=${sortBy}&order=${order}">&gt;</a>
                                    </li>
                                </c:if>

                                <%--  Còn trường hợp này nút nào cũng xài được--%>
                                <c:if test="${pageId >1 && pageId<haveMaxPage}">
                                    <li><a href="listUserForward?pageId=${pageId-1}&sortBy=${sortBy}&order=${order}">&lt;</a>
                                    </li>
                                    <c:forEach begin="1" end="${haveMaxPage}" var="i">
                                        <li id="${i}"><a
                                                href="listUserForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li><a href="listUserForward?pageId=${pageId+1}&sortBy=${sortBy}&order=${order}">&gt;</a>
                                    </li>
                                </c:if>
                                <%-- Trường hợp đang ở trang cuối thì chỉ ko được xài nút >--%>

                                <c:if test="${pageId ==haveMaxPage}">
                                    <li><a href="listUserForward?pageId=${pageId-1}&sortBy=${sortBy}&order=${order}">&lt;</a>
                                    </li>
                                    <c:forEach begin="1" end="${haveMaxPage}" var="i">
                                        <li id="${i}"><a
                                                href="listUserForward?pageId=${i}&sortBy=${sortBy}&order=${order}">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li><a>></a></li>
                                </c:if>
                            </c:if>
                        </ul>
            </div>
            <p style="color: red;padding: 100px"> ${result}</p>
        </div>

    </section>
</div>

<script>
    let arrow = document.querySelectorAll(".arrow");
    for (var i = 0; i < arrow.length; i++) {
        arrow[i].addEventListener("click", (e) => {
            let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
            arrowParent.classList.toggle("showMenu");
        });
    }
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".bx-menu");
    console.log(sidebarBtn);
    sidebarBtn.addEventListener("click", () => {
        sidebar.classList.toggle("close");
    });

    var myVar;

    function myFunction() {
        myVar = setTimeout(showPage, 1);
    }

    function showPage() {
        document.getElementById("loader").style.display = "none";
        document.getElementById("myDiv").style.display = "block";
    }

    document.addEventListener('DOMContentLoaded', function () {
        let active = document.querySelectorAll(".account");
        active.forEach(function (all) {
            if (all.innerHTML.toLowerCase() === "hoạt động") {
                all.classList.add('active-account');
            } else {
                all.classList.add('block-account');
            }
        });
    });
</script>

<%--Script xuất hiện bảng cho filter--%>
<script>
    document.getElementById('${pageId}').classList.add("active")

    function toggleFilter() {
        var dropdown = document.getElementById("filterDropdown");
        dropdown.style.display = (dropdown.style.display === "block") ? "none" : "block";
    }
</script>

</body>
<script src="https://kit.fontawesome.com/4c38acb8c6.js" crossorigin="anonymous"></script>
</html>