<%-- 
    Document   : approve-user-details
    Created on : May 10, 2024, 2:57:34 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-info text-center">Quản lý duyệt chủ trọ</h1> 

<div class="product-wrap">
    <div class="product-detail-wrap mb-30">
        <div class="row">
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="product-slider slider-arrow">
                    <c:forEach items="${lessorImages}" var="i">
                        <div class="product-slide">
                            <img src="${i.image}"alt="Image">
                        </div>
                    </c:forEach>
                </div>

                <div class="product-slider-nav">
                    <c:forEach items="${lessorImages}" var="i">
                        <div class="product-slide-nav">
                            <img src="${i.image}"alt="Image">
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="product-detail-desc pd-20 card-box height-100-p">
                    <c:forEach items="${lessorDetails}" var="l">
                        <div class="d-flex">

                            <span class="user-icon">
                                <img class="border-radius-100"src="${l.users.avatar}" alt="" style="width: 52px; height: 52px;">
                            </span>
                            <p class="user-name mt-3">${l.users.username} </p>
                        </div>
                        <p>Họ tên: ${l.users.firstName} ${l.users.lastName} </p>
                        <p>Địa chỉ: ${l.users.address}</p> 
                        <p>Số điện thoại: ${l.users.phone}</p>
                        <p>Số CCCD: ${l.cccd}</p> 
                        <c:url value="/approve-user/${l.id}" var="url" />
                        <c:url value="/api/approve-user/${l.id}/" var="urlOperation" />
                        <button class="btn btn-primary" 
                                onclick="approvePost('${urlOperation}', ${l.id})">Duyệt</button>
                        <button class="btn btn-danger" 
                                onclick="eDelete('${urlOperation}', ${l.id})">Từ chối</button> 
                    </c:forEach>

                </div>
            </div>

        </div>
    </div>
</div>
</div>
</div>


<script src="<c:url value="/src/plugins/slick/slick.min.js"/>"></script>
<!-- bootstrap-touchspin js -->
<script src="<c:url value="/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"/>"></script>
<script>
                                    jQuery(document).ready(function () {
                                        jQuery('.product-slider').slick({
                                            slidesToShow: 1,
                                            slidesToScroll: 1,
                                            arrows: true,
                                            infinite: true,
                                            speed: 1000,
                                            fade: true,
                                            asNavFor: '.product-slider-nav'
                                        });
                                        jQuery('.product-slider-nav').slick({
                                            slidesToShow: 3,
                                            slidesToScroll: 1,
                                            asNavFor: '.product-slider',
                                            dots: false,
                                            infinite: true,
                                            arrows: false,
                                            speed: 1000,
                                            centerMode: true,
                                            focusOnSelect: true
                                        });
                                        $("input[name='demo3_22']").TouchSpin({
                                            initval: 1
                                        });
                                    });
</script>