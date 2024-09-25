<%-- 
    Document   : lessor-post
    Created on : Apr 30, 2024, 10:30:37 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-primary text-center">Quản lý bài đăng chủ nhà trọ</h1>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Ảnh phòng trọ</th>
        <th>Tiêu đề</th>
        <th>Giá phòng</th>
        <th>Địa chỉ</th>
        <th>Tên chủ bài viết</th>
        <th>Ngày tạo</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach items="${lposts}" var="lp">
        <tr>
            <td>${lp[0]}</td>
            <td style="width:260px"><img class="card-img-top" 
                                         src="${lp[7]}"
                                         alt="Card image"></td>
            <td>${lp[1]}</td>
            <td>${lp[3]}VNĐ/Tháng</td>
            <td>${lp[4]},${lp[5]},${lp[6]}</td>
            <td>${lp[9]} ${lp[10]}</td>
            <td>${lp[11]}</td>
            <td>
                <c:url value="/lessor-post/${lp[0]}" var="url" />
                <c:url value="/api/lessor-post/${lp[0]}/" var="urlDelete" />
                <button class="btn btn-danger" 
                        onclick="eDelete('${urlDelete}', ${lp[0]})">Xóa</button>

            </td>
        </tr>
    </c:forEach>
</table>

<script src="<c:url value="/js/main.js"/>"></script>
