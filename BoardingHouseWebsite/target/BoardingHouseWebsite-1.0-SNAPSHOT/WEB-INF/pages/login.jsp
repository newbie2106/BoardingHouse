<%-- 
    Document   : login
    Created on : May 27, 2024, 5:47:58 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:url value="/login" var="action" />

<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 col-lg-7">
                <img src="vendors/images/login-page-img.png" alt="">
            </div>
            <div class="col-md-6 col-lg-5">
                <div class="login-box bg-white box-shadow border-radius-10">
                    <div class="login-title">
                        <h2 class="text-center text-primary">TRANG ĐĂNG NHẬP</h2>
                    </div>
                    <form method="post" action="${action}" >

                        <div class="input-group custom">
                            <input type="text" name="username"class="form-control form-control-lg" placeholder="Tên đăng nhập">
                            <div class="input-group-append custom">
                                <span class="input-group-text"><i class="icon-copy dw dw-user1"></i></span>
                            </div>
                        </div>
                        <div class="input-group custom">
                            <input type="password" name="password" class="form-control form-control-lg" placeholder="Mật khẩu">
                            <div class="input-group-append custom">
                                <span class="input-group-text"><i class="dw dw-padlock1"></i></span>
                            </div>
                        </div>
                        <div class="row pb-30">
                            <div class="col-6">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                                    <label class="custom-control-label" for="customCheck1">Ghi nhớ tôi</label>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="forgot-password"><a href="forgot-password.html">Quên mật khẩu</a></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-group mb-0">
                                    <!--
                                            use code for form submit
                                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Sign In">
                                    -->
                                    <div class="form-floating mt-3 mb-3">
                                        <input type="submit" value="Đăng nhập" class="btn btn-info" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<div class="container">
    <h1 class="text-center text-info my-2">Đăng nhập</h1>
    <form method="post" action="${action}" >
        <div class="form-floating mb-3 mt-3">
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
            <label for="username">Tên đăng nhập</label>
        </div>

        <div class="form-floating mt-3 mb-3">
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
            <label for="pwd">Mật khẩu</label>
        </div>
        <div class="form-floating mt-3 mb-3">
            <input type="submit" value="Đăng nhập" class="btn btn-info" />
        </div>
    </form>
</div>-->
