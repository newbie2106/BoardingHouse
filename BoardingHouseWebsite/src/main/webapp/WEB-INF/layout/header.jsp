<%-- 
    Document   : header
    Created on : Apr 25, 2024, 7:38:26 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .un-list-style {
        list-style: none;
    }

</style>

<div class="login-header box-shadow">
    <div class="container-fluid d-flex align-items-center">
        <div class="brand-logo">
            <a href="login.html">
                <img src="vendors/images/logo-home.png"alt="">
            </a>
        </div
        <ul class="navbar-nav">
            <li class="nav-item un-list-style">
                <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
            </li>
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item un-list-style">
                        <a class="nav-link" href="<c:url value="/"/>">
                            Chào ${pageContext.request.userPrincipal.name}!</a>
                    </li>
                    <li class="nav-item un-list-style">
                        <a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
                    </li>
                    <li class="nav-item dropdown un-list-style">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Quản lý tài khoản
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDarkDropdownMenuLink">
                            <li class="un-list-style">
                                <a class="dropdown-item" href="<c:url value="/approve-user"/>">Duyệt tài khoản </a>
                            </li>
                            <li class="un-list-style">
                                <a class="dropdown-item" href="<c:url value="/users"/>">Sửa role/Xóa tài khoản</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown un-list-style">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Quản lý bài đăng
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDarkDropdownMenuLink">
                            <li class="un-list-style">
                                <a class="dropdown-item " href="<c:url value="/post"/>">Tất cả bài đăng</a>
                            </li>
                            <li class="un-list-style">
                                <a class="dropdown-item" href="<c:url value="/lessor-post"/>">Bài đăng của chủ trọ</a>
                            </li>
                            <li class="un-list-style">
                                <a class="dropdown-item" href="<c:url value="/customer-post"/>">Bài đăng của khách hàng</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item un-list-style">
                        <a class="nav-link" href="<c:url value="/stats"/>">Thống kê</a>
                    </li>
                    <li class="nav-item un-list-style">
                        <a class="nav-link" href="<c:url value="/"/>">Quản lý bình luận</a>
                    </li>
                </c:when>
                <c:when test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item un-list-style">
                        <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                    </li>
                </c:when>
            </c:choose>
        </ul>
    </div>

</div>