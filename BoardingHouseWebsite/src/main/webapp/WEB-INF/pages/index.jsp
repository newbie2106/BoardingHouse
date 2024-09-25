<%-- 
    Document   : index
    Created on : Apr 24, 2024, 10:28:59 PM
    Author     : tongh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center text-info mt-1">ĐÂY LÀ TRANG CHỦ</h1> 

<h2 class="text-danger">Bài viết của chủ nhà trọ</h2>

<div class="product-wrap">
    <div class="product-list">
        <ul class="row">
            <c:forEach items="${lposts}" var="p">
                <li class="col-lg-4 col-md-6 col-sm-12">
                    <div class="product-box">
                        <div class="producct-img"><img src="${p[7]}"alt="Card image"></div>
                        <div class="product-caption">
                            <h4><a href="#">${p[1]}</a></h4>
                            <p class="card-text">${p[2]}</p>            
                            <p class="card-text">Số lượng người ở: ${p[13]}</p>            
                            <div class="price">
                                <p class="card-text">${p[3]} VNĐ/Tháng</p>
                            </div>
                            <p class="card-text">
                                <img style="width:30px" class="card-img-top" 
                                     src="${p[12]}"
                                     alt="Card image">
                                ${p[9]} ${p[10]}
                            </p>
                            <p class="card-text">${p[4]}, ${p[5]}, ${p[6]}</p>
                            <p class="card-text fs-6">Ngày đăng: ${p[11]}</p>
                            <a href="#" class="btn btn-outline-primary">Xem chi tiết</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<h2 class="text-danger">Bài viết của khách hàng</h2>
<div class="product-wrap">
    <div class="product-list">
        <ul class="row">
            <c:forEach items="${cposts}" var="cp">
                <li class="col-lg-4 col-md-6 col-sm-12">
                    <div class="product-box">
                        <div class="product-caption">

                            <h4><a href="#">${cp[1]}</a></h4>
                            <p class="card-text">${cp[2]}</p>            
                            <p class="card-text">Tại khu vực: ${cp[3]}</p>            
                            <div class="price">
                                <p class="card-text">${p[3]} VNĐ/Tháng</p>
                            </div>
                            <p class="card-text">
                                <img style="width:30px" class="card-img-top" 
                                     src="${cp[6]}"
                                     alt="Card image">
                                ${cp[4]} ${cp[5]}
                            </p>
                            <p class="card-text fs-6">Ngày đăng: ${cp[7]}</p>
                            <a href="#" class="btn btn-outline-primary">Xem chi tiết</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
