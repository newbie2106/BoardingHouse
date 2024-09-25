<%-- 
    Document   : users
    Created on : Apr 28, 2024, 6:05:10 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-info mt-1">Quản Lý Người Dùng</h1>

<table class="table table-striped">
    <tr>
        <th>Ảnh đại diện</th>
        <th>Tên tài khoản</th>
        <th>Họ</th>
        <th>Tên</th>
        <th>Ngày tạo</th>
        <th>Vai trò</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td style="width:260px"><img class="card-img-top" 
                                         src="${u[0]}"
                                         alt="Card image"></td>
            <td>${u[1]}</td>
            <td>${u[2]}</td>
            <td>${u[3]}</td>
            <td>${u[4]}</td>
            <td>${u[5]}</td>
            <td>
                <c:url value="/users/${u[6]}" var="url" />
                <c:url value="/api/users/${u[6]}/" var="urlDelete" />
                <button class="btn btn-danger" 
                        onclick="eDelete('${urlDelete}', ${u[6]})">Xóa</button>

            </td>
        </tr>
    </c:forEach>
</table>



<script src="<c:url value="/js/main.js"/>"></script>

